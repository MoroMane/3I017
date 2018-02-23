package test;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;

public class Test_Friend {

	public static void main(String[] args) throws JSONException, SQLException 
	{
		Connection c=bd.Database.getMySqlConnection();
		System.out.println("Login: "+servicesClasses.Friend.AddFriend("test",38));
		System.out.println("Login: "+servicesClasses.Friend.RemoveFriend("ByEjjWBWcxrcEVBNewsiWfTjMqErbEHT",38));
		c.close();
	}

}
