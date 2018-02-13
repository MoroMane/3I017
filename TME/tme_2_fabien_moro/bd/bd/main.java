package bd;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;


public class main 
{
	public static void main(String[] args) throws SQLException 
	{
		//Database db=new Database("Test");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/TANG_Fabien","root","root");
		Statement lecture = c.createStatement();
		ResultSet curseur = lecture.executeQuery("Select * from user;");
		while (curseur.next())
		{
			System.out.println(curseur.getString("id"));
			System.out.println(curseur.getString("login"));
			System.out.println(curseur.getString("nom"));
			System.out.println(curseur.getString("prenom"));
			System.out.println(curseur.getString("pwd"));
		}
		curseur.close();
		lecture.close();
		c.close();
		System.out.println(UserTools.userExist("3408748"));		
	}
}
