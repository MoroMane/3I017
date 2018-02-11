package servicesClasses;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;
import servicesTools.serviceRefused;

public class User
{
	public static JSONObject CreateUser(String nom,String prenom, String user, String mdp)throws JSONException, SQLException
	{
		JSONObject ret=new JSONObject();
		if (bd.UserTools.userExist(user))
		{
			ret=serviceRefused.serviceRefused("L'utilisateur existe déjà",100);
			return ret;
		}
		else
		{
			ret.put("Status","ok");
			bd.UserTools.userAdd(user);
			return ret;
		}
	}
	
	public static JSONObject DeleteUser(String nom,String prenom, String user, String mdp)throws JSONException, SQLException
	{
		JSONObject ret=new JSONObject();
		if (bd.UserTools.userExist(user))
		{
			bd.UserTools.userDel(user);
			ret.put("Status","ok");
			return ret;
		}
		else
		{
			ret.put("L'utilisateur n'existe pas",100);
			return ret;
		}
	}
	
	public static JSONObject Login(String user, String mdp)throws JSONException, SQLException
	{
		JSONObject ret=new JSONObject();
		if (!bd.UserTools.userExist(user))
		{
			ret.put("Status","KO");
			ret.put("Error","Users not exists");
			return ret;
		}
		if(!bd.UserTools.checkPassword(user,mdp))
		{
			ret.put("Status","KO");
			ret.put("Error","Wrong Password");
			return ret;
		}
		boolean root=bd.UserTools.isRoot(user);
		String key = bd.UserTools.insererConnexion(user,root);
		ret.put("Status","OK");
		ret.put("Key",key);
		return ret;
	}
	
	public static JSONObject Logout(String key)throws JSONException
	{
		JSONObject ret=new JSONObject();
		if (bd.UserTools.insererDeconnexion(key))
			ret.put("Status", "OK");
		return ret;
	}
}
