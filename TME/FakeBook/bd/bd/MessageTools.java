package bd;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.bson.BasicBSONObject;
import org.bson.types.ObjectId;
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
	
	//A DEBUG
	public static BasicDBObject ListMessage(String key,String id_users) throws UnknownHostException
	{	
		//int id_user = UserTools.get_userId_v2(key);
		DBCollection message=Database.getCollection("message");
		BasicDBObject retour=new BasicDBObject();
		BasicDBObject query=new BasicDBObject("id_user",id_users);
		DBCursor c= message.find(query);
		while (c.hasNext())
		{
			DBObject obj=c.next();
			retour.append(id_users, obj.get("content"));
		}
		return retour;
	}
}
