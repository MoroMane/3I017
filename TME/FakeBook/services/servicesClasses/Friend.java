package servicesClasses;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

public class Friend 
{
	public static JSONObject AddFriend(String key,int id_friend)throws JSONException, SQLException
	{
		return bd.UserTools.ajouterAmis(key, id_friend);
	}
	
	public static JSONObject RemoveFriend(String key,int id_friend)throws JSONException, SQLException
	{
		return bd.UserTools.retirerAmis(key,id_friend);
	}
}
