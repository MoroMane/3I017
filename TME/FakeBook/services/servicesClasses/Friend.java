package servicesClasses;

import org.json.JSONException;
import org.json.JSONObject;

public class Friend 
{
	public static JSONObject AddFriend(String key,String id_friend)throws JSONException
	{
		JSONObject ret=new JSONObject();
		if (bd.UserTools.ajouterAmis(key,id_friend))
			ret.put("Status","ok");
		else
			ret.put("Status", "ko");
		return ret;
	}
	
	public static JSONObject RemoveFriend(String key,String id_friend)throws JSONException
	{
		JSONObject ret=new JSONObject();
		if (bd.UserTools.retirerAmis(key,id_friend))
			ret.put("Status","ok");
		else
			ret.put("Status", "ko");
		return ret;
	}
}
