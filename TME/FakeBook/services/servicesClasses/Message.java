package servicesClasses;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;

public class Message 
{
	public static JSONObject AddMessage(String key,String message)throws JSONException, UnknownHostException, SQLException
	{
		return bd.MessageTools.AddMessage(key,message);
	}
	
	public static JSONObject RemoveMessage(String key,ObjectId id_message)throws JSONException, UnknownHostException, SQLException
	{
		return bd.MessageTools.RemoveMessage(key,id_message);
	}
	
	public static BasicDBObject ListMessage(String key, String id_users)throws JSONException, UnknownHostException
	{
		return bd.MessageTools.ListMessage(key,id_users);
	}
}