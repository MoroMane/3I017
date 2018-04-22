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
	public static JSONObject AddMessage(String key,String message) throws UnknownHostException, SQLException, JSONException
	{
		DBCollection message_co=Database.getCollection("message");
		BasicDBObject bdo=new BasicDBObject();
		int id_user = UserTools.get_userId_v2(key);
		GregorianCalendar calendar = new GregorianCalendar();
		Date today= calendar.getTime();
		JSONObject ret=new JSONObject();
		if (id_user==0)
			return serviceRefused.serviceRefused("Key associé à aucun utilisateur", 100);
		else
		{
			int idm=(int)( Math.random()*( 1000000000 - 1 + 1 ) ) + 1;
			bdo.put("id", idm);
			bdo.put("id_user", id_user);
			bdo.put("content", message);
			bdo.put("date",today);
			bdo.put("comments", new ArrayList<String>());
			bdo.put("like", 0);
			message_co.insert(bdo);
			ret.put("id",idm);
			ret.put("id_user", id_user);
			ret.put("content", message);
			ret.put("date",today);
			ret.put("comments", new ArrayList<String>());
			ret.put("like", 0);
			return ret;
		}
	}
	
	public static JSONObject AddMessageMain(String key,String message) throws UnknownHostException, SQLException, JSONException
	{
		DBCollection message_co=Database.getCollection("message_main");
		BasicDBObject bdo=new BasicDBObject();
		int id_user = UserTools.get_userId_v2(key);
		GregorianCalendar calendar = new GregorianCalendar();
		Date today= calendar.getTime();
		JSONObject ret=new JSONObject();
		if (id_user==0)
			return serviceRefused.serviceRefused("Key associé à aucun utilisateur", 100);
		else
		{
			int idm=(int)( Math.random()*( 1000000000 - 1 + 1 ) ) + 1;
			bdo.put("id", idm);
			bdo.put("id_user", id_user);
			bdo.put("content", message);
			bdo.put("date",today);
			bdo.put("comments", new ArrayList<String>());
			bdo.put("like", 0);
			message_co.insert(bdo);
			ret.put("id",idm);
			ret.put("id_user", id_user);
			ret.put("content", message);
			ret.put("date",today);
			ret.put("comments", new ArrayList<String>());
			ret.put("like", 0);
			return ret;
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
		int id_int = Integer.parseInt(id_users); 
		BasicDBObject query=new BasicDBObject("id_user",id_int);
		DBCursor c= message.find(query);
		List <JSONObject> lr = new ArrayList<JSONObject>();
		while (c.hasNext())
		{
			DBObject obj=c.next();
			JSONObject temp=new JSONObject();			
			String s = ((BasicBSONObject) obj).getString("content");
			temp.put("text", s);
			Integer id = ((BasicBSONObject) obj).getInt("id");
			temp.put("id", id);
			String login = UserTools.get_userLogin2(id_users);
			//String logins=Integer.toString(login);
			temp.put("login",login);
			Date d=((BasicBSONObject) obj).getDate("date");
			temp.put("date", d);
			temp.put("comments", ((BasicBSONObject) obj).get("comments"));
			temp.put("like", ((BasicBSONObject) obj).getInt("like"));
			lr.add(temp);
		}
		return lr;
	}	
	
	public static List<JSONObject> ListMessageMain(String key,String id_users) throws UnknownHostException, JSONException, SQLException
	{	
		DBCollection message=Database.getCollection("message_main");
		//BasicDBObject retour=new BasicDBObject();
		//int id_int = Integer.parseInt(id_users); 
		//BasicDBObject query=new BasicDBObject("id_user",id_int);
		//DBCursor c= message.find(query);
		DBCursor c= message.find();
		List <JSONObject> lr = new ArrayList<JSONObject>();
		while (c.hasNext())
		{
			DBObject obj=c.next();
			JSONObject temp=new JSONObject();			
			String s = ((BasicBSONObject) obj).getString("content");
			temp.put("text", s);
			Integer id = ((BasicBSONObject) obj).getInt("id");
			Integer idu = ((BasicBSONObject) obj).getInt("id_user");
			temp.put("id", id);
			String a=Integer.toString(idu);
			String login = UserTools.get_userLogin2(a);
			//String logins=Integer.toString(login);
			temp.put("login",login);
			Date d=((BasicBSONObject) obj).getDate("date");
			temp.put("date", d);
			temp.put("comments", ((BasicBSONObject) obj).get("comments"));
			temp.put("like", ((BasicBSONObject) obj).getInt("like"));
			lr.add(temp);
		}
		return lr;
	}
}
