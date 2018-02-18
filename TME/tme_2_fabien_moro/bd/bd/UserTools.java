package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTools 
{
	public static boolean userExist(String user)throws SQLException
	{
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/TANG_Fabien","root","root");
		Statement lecture = c.createStatement();
		String query="SELECT id FROM user WHERE login='"+user+"';";
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
	
	public static boolean userAdd(String user) throws SQLException
	{
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/TANG_Fabien","root","root");
		Statement lecture = c.createStatement();
		String query="INSERT into user (login) values ('"+user+"');";
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
	
	public static boolean userDel(String user) throws SQLException
	{
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/TANG_Fabien","root","root");
		Statement lecture = c.createStatement();
		String query="DELETE from user where login='"+user+"';";
		ResultSet curseur = lecture.executeQuery(query);
		boolean retour;	
		if (curseur.next())
			retour=false;
		else
			retour=true;
		curseur.close();
		lecture.close();
		c.close();
		return retour;
	}
	
	public static boolean checkPassword(String user, String mdp)
	{
		return true;
	}
	
	public static boolean isRoot(String user)
	{
		return true;
	}
	
	public static String insererConnexion(String user, boolean root)
	{
		return "bonjour";
	}
	
	public static boolean insererDeconnexion(String key)
	{
		return true;
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
