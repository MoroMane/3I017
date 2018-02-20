package bd;

import java.net.UnknownHostException;
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
	public static DBCollection addMessage(int id_user,String content) throws UnknownHostException
	{
		DBCollection message=Database.getCollection("message");
		BasicDBObject bdo=new BasicDBObject();
		bdo.put("id_user", id_user);
		bdo.put("content", content);
		message.insert(bdo);
		return message;
	}
	
	
	//To check
	public static List<String> getMessages(int[] users) throws UnknownHostException
	{	
		DBCollection message=Database.getCollection("message");
		List<String> retour= new ArrayList<String>();
		for (int a : users)
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
