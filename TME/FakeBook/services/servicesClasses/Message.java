package servicesClasses;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;

import servicesTools.serviceAccepted;
import servicesTools.serviceRefused;

import com.mongodb.DBCollection;

public class Message 
{
	public static DBCollection AddMessage(String key,String message)throws JSONException, UnknownHostException, SQLException
	{
		return bd.MessageTools.AddMessage(key,message);
	}
	
	public static DBCollection RemoveMessage(String key,ObjectId id_message)throws JSONException, UnknownHostException, SQLException
	{
		return bd.MessageTools.RemoveMessage(key,id_message);
	}
	
	public static List<String> ListMessage(List<String> users)throws JSONException, UnknownHostException
	{
		return bd.MessageTools.ListMessage(users);
	}
}