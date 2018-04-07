package test;

import java.sql.Connection;
import java.sql.SQLException;
import org.json.JSONException;

public class Test_Log {
	public static void main(String[] args) throws SQLException, JSONException, ClassNotFoundException {
	Connection c=bd.Database.getMySqlConnection();
	System.out.println("Login: "+servicesClasses.User.Login("3408748", "monmdp"));
	System.out.println("Logout: "+servicesClasses.User.Logout("vVRXCntuLKHqQHCYGUXiRLzxWABECalt"));
	c.close();
	}
}
