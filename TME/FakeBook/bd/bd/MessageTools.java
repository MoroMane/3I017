package bd;

import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bson.BasicBSONObject;
import org.json.JSONObject;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.BasicDBObject;

public class MessageTools
{
	public static DBCollection AddMessage(String key,String message) throws UnknownHostException, SQLException
	{
		DBCollection message_co=Database.getCollection("message");
		BasicDBObject bdo=new BasicDBObject();
		int id_user = UserTools.get_userId_v2(key);
		if (id_user==0)
		{
			System.out.println("Key associé à aucun utilisateur");
		}
		else
		{
			bdo.put("id_user", id_user);
			bdo.put("content", message);
			message_co.insert(bdo);
		}
		return message_co;
	}
	////////////////////////////////////A Coder//////////////////////////////////
	public static DBCollection RemoveMessage(String key,int id_message) throws UnknownHostException, SQLException
	{
		DBCollection message=Database.getCollection("message");
		int id_user = UserTools.get_userId_v2(key);
		return message;
	}
	
	////////////////////////////////////A TESTER/DEBUGUER////////////////////////
	public static List<String> ListMessage(List<String> users) throws UnknownHostException
	{	
		DBCollection message=Database.getCollection("message");
		List<String> retour= new ArrayList<String>();
		for (String a : users)
		{
			BasicDBObject q1=new BasicDBObject("id_user",a);
			List<BasicDBObject> maliste=new ArrayList<BasicDBObject>();
			maliste.add(q1);
			BasicDBObject query=new BasicDBObject ();
			DBCursor c= message.find(query);
			while (c.hasNext())
			{
				DBObject obj=c.next();
				retour.add(((BasicBSONObject) obj).getString("content"));
			}
		}
		return retour;
	}
}
