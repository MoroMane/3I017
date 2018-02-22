package tme_2_fabien_moro;

import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import org.json.JSONException;


public class Test_bdd
{
	public static void main(String[] args) throws SQLException, UnknownHostException, JSONException 
	{
		bd.UserTools.userAdd("3408748","monmdp","Fabien","Tang");
		bd.UserTools.userAdd("3928174","montoya","Juan","Deagle");
		servicesClasses.User.CreateUser("392811","montoy","Jua","Deage");
		bd.UserTools.userDel("3928174");
		bd.UserTools.userDel("392811");
		Connection c=bd.Database.getMySqlConnection();
		Statement lecture = c.createStatement();
		ResultSet curseur = lecture.executeQuery("Select * from Users;");
		while (curseur.next())
		{
			System.out.println(curseur.getString("id"));
			System.out.println(curseur.getString("login"));
			System.out.println(curseur.getString("nom"));
			System.out.println(curseur.getString("prenom"));
			System.out.println(curseur.getString("password"));
		}
		curseur.close();
		lecture.close();
		c.close();
		System.out.println(bd.UserTools.userExist("3408748"));
		System.out.println(bd.UserTools.checkPassword("3408748","monmdp"));
		//bd.MessageTools.addMessage(3520543,"mow");
	}
}
