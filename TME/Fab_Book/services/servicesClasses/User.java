package servicesClasses;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import servicesTools.serviceRefused;

public class User
{
	public static JSONObject CreateUser(String login,String mdp,String prenom,String nom)throws JSONException, SQLException
	{
		if (nom == null || mdp == null || login == null || prenom == null)
			return serviceRefused.serviceRefused("argument manquant",100);
		if (bd.UserTools.userExist(login))
			return serviceRefused.serviceRefused("user déjà existant",100);
		return bd.UserTools.userAdd(login,mdp,prenom,nom);
	}
	
	public static JSONObject DeleteUser(String login)throws JSONException, SQLException
	{
		if (login == null)
			return serviceRefused.serviceRefused("argument manquant",100);
		if (!bd.UserTools.userExist(login))
			return serviceRefused.serviceRefused("user déjà inexistant",100);
		return bd.UserTools.userDel(login);
	}
	
	public static JSONObject Login(String login, String mdp)throws JSONException, SQLException
	{
		JSONObject ret=new JSONObject();
		if (!bd.UserTools.userExist(login))
		{
			ret.put("Status","KO");
			ret.put("Error","Users not exists");
			return ret;
		}
		if(!bd.UserTools.checkPassword(login,mdp))
		{
			ret.put("Status","KO");
			ret.put("Error","Wrong Password");
			return ret;
		}
		//boolean root=bd.UserTools.isRoot(login);
		//String key = bd.UserTools.insererConnexion(login,root);
		String key = bd.UserTools.insererConnexion(login);
		ret.put("Status","OK");
		ret.put("Key",key);
		return ret;
	}
	
	public static JSONObject Logout(String key)throws JSONException, SQLException
	{
		if (key== null)
			return serviceRefused.serviceRefused("key manquant",100);
		return bd.UserTools.insererDeconnexion(key);
	}
}
