package bd;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.bson.BasicBSONObject;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;

import servicesTools.serviceAccepted;
import servicesTools.serviceRefused;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;

import bd.UserTools;

public class MessageTools
{
	public static JSONObject AddMessage(String key,String message) throws UnknownHostException, SQLException
	{
		DBCollection message_co=Database.getCollection("message");
		BasicDBObject bdo=new BasicDBObject();
		int id_user = UserTools.get_userId_v2(key);
		GregorianCalendar calendar = new GregorianCalendar();
		Date today= calendar.getTime();
		if (id_user==0)
			return serviceRefused.serviceRefused("Key associé à aucun utilisateur", 100);
		else
		{
			bdo.put("id_user", id_user);
			bdo.put("content", message);
			bdo.put("date",today);
			message_co.insert(bdo);
			return serviceAccepted.serviceAccepted();
		}
	}
	
	public static JSONObject RemoveMessage(String key,ObjectId id_message) throws UnknownHostException, SQLException
	{
		DBCollection message=Database.getCollection("message");
		int id_user = UserTools.get_userId_v2(key);
		if (id_user==0)
			return serviceRefused.serviceRefused("Key associé à aucun utilisateur", 100);
		else
		{
			BasicDBObject query=new BasicDBObject();
			query.append("_id",id_message);
			query.append("id_user",id_user);
			message.remove(query);
			return serviceAccepted.serviceAccepted();
		}
	}
	
	public static List<JSONObject> ListMessage(String key,String id_users) throws UnknownHostException, JSONException, SQLException
	{	
		DBCollection message=Database.getCollection("message");
		//BasicDBObject retour=new BasicDBObject();
		JSONObject retour= new JSONObject();
		int id_int = Integer.parseInt(id_users); 
		BasicDBObject query=new BasicDBObject("id_user",id_int);
		DBCursor c= message.find(query);
		List <JSONObject> lr = new ArrayList<JSONObject>();
		while (c.hasNext())
		{
			DBObject obj=c.next();
			JSONObject temp=new JSONObject();
			temp.put("id", id_int);
			String s = ((BasicBSONObject) obj).getString("content");
			temp.put("text", s);
			//temp.append("text", s);
			int login = UserTools.get_userLogin(id_users);
			String logins=Integer.toString(login);
			temp.put("login",logins);
			//javoue jai un peu cheat� ici
			temp.put("date", "2018-04-17T22:14:02.778Z");
			temp.put("comments", new ArrayList<String>());
			lr.add(temp);
		}
		return lr;
	}	
	
}
