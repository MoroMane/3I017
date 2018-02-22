package tme_2_fabien_moro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;

public class Test_login {
	public static void main(String[] args) throws SQLException, JSONException, ClassNotFoundException {
	Connection c=DriverManager.getConnection("jdbc:mysql://localhost/fabien_3i017","root","root");
	Statement lecture = c.createStatement();
	System.out.println(servicesClasses.User.Login("3408748","monmdp"));
	ResultSet curseur = lecture.executeQuery("Select * from Sessions;");
	while (curseur.next())
	{
		System.out.println("--------------------------");
		System.out.println(curseur.getString("id_user"));
		System.out.println(curseur.getString("time"));
		System.out.println(curseur.getString("key"));
		//System.out.println(curseur.getString("isRoot"));
	}
	curseur.close();
	lecture.close();
	c.close();
	}
}
