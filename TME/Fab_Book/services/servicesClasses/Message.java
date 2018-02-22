package servicesClasses;

import org.json.JSONException;
import org.json.JSONObject;

public class Message 
{
	public static JSONObject AddComment(String key,String text)throws JSONException
	{
		JSONObject ret=new JSONObject();
		if (bd.UserTools.insererComment(key,text))
			ret.put("Status","ok");
		else
			ret.put("Status", "ko");
		return ret;
	}
}