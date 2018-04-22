package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import org.json.JSONObject;

import servicesTools.serviceRefused;
import servicesTools.serviceAccepted;

public class UserTools 
{
	public static boolean userExist(String login)throws SQLException
	{
		Connection c=bd.Database.getMySqlConnection();
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
	
	public static JSONObject userAdd(String login, String mdp, String prenom, String nom) throws SQLException
	{
		Connection c=bd.Database.getMySqlConnection();
		Statement lecture = c.createStatement();
		String query="insert into Users values (NULL,'"+login+"','"+mdp+"','"+prenom+"','"+nom+"');";
		JSONObject retour = serviceAccepted.serviceAccepted();
		try
		{
			lecture.executeUpdate(query);
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
		Connection c=bd.Database.getMySqlConnection();
		Statement lecture = c.createStatement();
		String query="DELETE from Users where login='"+login+"';";
		JSONObject retour = serviceAccepted.serviceAccepted();
		try
		{
			lecture.executeUpdate(query);
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
		Connection c=bd.Database.getMySqlConnection();
		Statement lecture = c.createStatement();
		String query="select * from Users where login='"+login+"';";
		ResultSet cursor=lecture.executeQuery(query);
		boolean retour;
		if (!cursor.next())
			retour=false;
		else
			retour=cursor.getString("password").equals(mdp);
		lecture.close();
		c.close();
		return retour;
	}
	
	//////////////////////////////////// A TESTER/DEBUGUER////////////////////////
	public static boolean isRoot(String login) throws SQLException
	{
		Connection c=bd.Database.getMySqlConnection();
		Statement lecture = c.createStatement();
		String query="select * from Sessions where login='"+login+"';";
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
		Connection c=bd.Database.getMySqlConnection();
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
	//////////////////////////////////////////////////////////////////////////////
	
	public static int get_userId(String login) throws SQLException
	{		
		Connection c=bd.Database.getMySqlConnection();
		Statement lecture = c.createStatement();
		String query="select * from Users where login='"+login+"';";
		ResultSet cursor=lecture.executeQuery(query);
		int user_id=0;
		while (cursor.next())
			user_id=cursor.getInt("Id");
		lecture.close();
		c.close();
		return user_id;
	}
	
	public static int get_userId_v2(String key) throws SQLException
	{		
		Connection c=bd.Database.getMySqlConnection();
		Statement lecture = c.createStatement();
		String query="select * from Sessions s where s.key='"+key+"';";
		ResultSet cursor=lecture.executeQuery(query);
		int user_id=0;
		while (cursor.next())
			user_id=cursor.getInt("id_user");
		lecture.close();
		c.close();
		return user_id;
	}
	
	public static int get_userLogin(String id) throws SQLException
	{		
		Connection c=bd.Database.getMySqlConnection();
		Statement lecture = c.createStatement();
		String query="select * from Users where id='"+id+"';";
		ResultSet cursor=lecture.executeQuery(query);
		int user_login=0;
		while (cursor.next())
			user_login=cursor.getInt("login");
		lecture.close();
		c.close();
		return user_login;
	}
	
	public static String get_userLogin2(String id) throws SQLException
	{		
		Connection c=bd.Database.getMySqlConnection();
		Statement lecture = c.createStatement();
		String query="select * from Users where id='"+id+"';";
		ResultSet cursor=lecture.executeQuery(query);
		String user_login="";
		while (cursor.next())
			user_login=cursor.getString("login");
		lecture.close();
		c.close();
		return user_login;
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
		Connection c=bd.Database.getMySqlConnection();
		Statement lecture = c.createStatement();
		String key = generate_key();
		int id_user = get_userId(login);
		//changer dans le futur le false de boolean
		String query="INSERT into Sessions values ("+id_user+",CURRENT_TIMESTAMP,'"+key+"',false,0);";
		//System.out.println(query);
		lecture.executeUpdate(query);
		lecture.close();
		c.close();
		return key;
	}
	
	public static JSONObject insererDeconnexion(String key) throws SQLException
	{
		Connection c=bd.Database.getMySqlConnection();
		Statement lecture = c.createStatement();
		String query="update Sessions s set expired=true where s.key='"+key+"';";
		lecture.executeUpdate(query);
		lecture.close();
		c.close();
		return serviceAccepted.serviceAccepted();
	}

	public static boolean insererComment(String key, String text)
	{
		return true;
	}
	
	public static JSONObject ajouterAmis(String key, int id_friend) throws SQLException
	{
		Connection c=bd.Database.getMySqlConnection();
		Statement lecture = c.createStatement();
		int user_id=get_userId_v2(key);
		String query="insert into Friends values ("+user_id+","+id_friend+",CURRENT_TIMESTAMP)";
		JSONObject retour = serviceAccepted.serviceAccepted();
		try
		{
			lecture.executeUpdate(query);
		}
		catch (SQLException e)
		{
			retour = serviceRefused.serviceRefused("KO",100);
		}
		lecture.close();
		c.close();
		return retour;
	}
	
	public static JSONObject retirerAmis(String key, int id_friend) throws SQLException
	{
		Connection c=bd.Database.getMySqlConnection();
		Statement lecture = c.createStatement();
		int user_id=get_userId_v2(key);
		String query="delete from Friends where id_user="+user_id+" and id_friend="+id_friend+";";
		JSONObject retour = serviceAccepted.serviceAccepted();
		try
		{
			lecture.executeUpdate(query);
		}
		catch (SQLException e)
		{
			retour = serviceRefused.serviceRefused("KO",100);
		}
		lecture.close();
		c.close();
		return retour;
	}
}
