package bd;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.json.JSONObject;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

import servicesTools.serviceRefused;
import servicesTools.serviceAccepted;

public class UserTools 
{
	public static boolean userExist(String login)throws SQLException
	{
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/fabien_3i017","root","root");
		Statement lecture = c.createStatement();
		String query="SELECT login FROM Users WHERE login='"+login+"';";
		ResultSet curseur = lecture.executeQuery(query);		
		boolean retour;		
		if (curseur.next())
			retour=true;
		else
			retour=false;
		curseur.close();
		lecture.close();
		c.close();
		return retour;
	}
	
	public static JSONObject userAdd(String login, String nom, String prenom, String mdp) throws SQLException
	{
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/fabien_3i017","root","root");
		Statement lecture = c.createStatement();
		String query="INSERT into Users values ("+login+","+nom+","+prenom+","+mdp+");";
		JSONObject retour = serviceAccepted.serviceAccepted();
		try
		{
			lecture.executeQuery(query);
		}
		catch (SQLException e)
		{
			retour = serviceRefused.serviceRefused("KO",100);
		}
		lecture.close();
		c.close();
		return retour;
	}
	
	public static JSONObject userDel(String login) throws SQLException
	{
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/fabien_3i017","root","root");
		Statement lecture = c.createStatement();
		String query="DELETE from Users where login='"+login+"';";
		JSONObject retour = serviceAccepted.serviceAccepted();
		try
		{
			lecture.execute(query);
		}
		catch (SQLException e)
		{
			retour = serviceRefused.serviceRefused("KO",100);
		}
		lecture.close();
		c.close();
		return retour;
	}
	
	public static boolean checkPassword(String login, String mdp) throws SQLException
	{
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/fabien_3i017","root","root");
		Statement lecture = c.createStatement();
		String query="select * from Users where login='"+login+"' and pwd='"+mdp+"';";
		ResultSet cursor=lecture.executeQuery(query);
		boolean retour;
		if (cursor.next())
			retour=true;
		else
			retour=false;
		lecture.close();
		c.close();
		return retour;
	}
	
	public static boolean isRoot(String login) throws SQLException
	{
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/fabien_3i017","root","root");
		Statement lecture = c.createStatement();
		String query="select * from Users where login='"+login+"';";
		ResultSet cursor=lecture.executeQuery(query);
		boolean retour;
		boolean reponse;
		reponse = cursor.getBoolean("isRoot");
		if (reponse)
			retour= true;
		else
			retour= false;
		lecture.close();
		c.close();
		return retour;
	}
	
	public static boolean isConnected (String login) throws SQLException
	{
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/fabien_3i017","root","root");
		Statement lecture = c.createStatement();
		String query="select connect from Sessions where login='"+login+"';";
		ResultSet cursor=lecture.executeQuery(query);
		boolean retour=false;
		while (cursor.next())
			retour=cursor.getBoolean("connect");
		lecture.close();
		c.close();
		return retour;
	}
	
	public static int get_userId(String login) throws SQLException
	{		
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/fabien_3i017","root","root");
		Statement lecture = c.createStatement();
		String query="select * from Users where login='"+login+"';";
		ResultSet cursor=lecture.executeQuery(query);
		int user_id=0;
		while (cursor.next())
			user_id=cursor.getInt("userId");
		lecture.close();
		c.close();
		return user_id;
	}
	
	public static String generate_key() 
	{
		String key = "";
		char c;
		for(int i=0; i<32; i++) 
		{
			Random r = new Random();
			if(Math.random() < 0.5) 
				c = (char)(r.nextInt(26) + 'A');
			else
				c = (char)(r.nextInt(26) + 'a');
			key += c;			
		}
		return key;		
	}
	
	public static String insererConnexion(String login) throws SQLException
	{
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/fabien_3i017","root","root");
		Statement lecture = c.createStatement();
		String key = generate_key();
		int id_user = get_userId(login);
		String query="insert into Sessions(key_u,idUser) values ('"+key+"',"+id_user+");";
		lecture.executeQuery(query);
		lecture.close();
		c.close();
		return key;
	}
	
	
	public static JSONObject insererDeconnexion(String key) throws SQLException
	{
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/fabien_3i017","root","root");
		Statement lecture = c.createStatement();
		String query="update Sessions set connect = 0 where key_u='"+key+"';";
		lecture.executeQuery(query);
		lecture.close();
		c.close();
		return serviceAccepted.serviceAccepted();
	}
		
	public static boolean insererComment(String key, String text)
	{
		return true;
	}
	
	public static boolean ajouterAmis(String key, String id_friend)
	{
		return true;
	}
	
	public static boolean retirerAmis(String key, String id_friend)
	{
		return true;
	}
}
