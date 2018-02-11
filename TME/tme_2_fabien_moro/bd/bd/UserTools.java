package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class UserTools 
{
	public static boolean userExist(String user)throws SQLException
	{
		Connection con=DataBase.getMySqlConnection();
		String query="SELECT id FROM users WHERE login='"+user+"';";
		Statement st= (Statement) con.createStatement();
		ResultSet res=st.executeQuery(query);
		boolean retour;
		if (res.next())
			retour=true;
		else
			retour=false;
		res.close();
		st.close();
		con.close();
		return retour;
	}
	
	public static boolean userAdd(String user)
	{
		return true;
	}
	
	public static boolean userDel(String user)
	{
		return true;
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
