package tme_2_fabien_moro;

import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;


public class Test_bdd
{
	public static void main(String[] args) throws SQLException, UnknownHostException 
	{
		//Database db=new Database("Test");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost/fabien_3i017","root","root");
		Statement lecture = c.createStatement();
		ResultSet curseur = lecture.executeQuery("Select * from Users;");
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
		System.out.println(bd.UserTools.userExist("TANG Fabien"));	
		bd.MessageTools.addMessage(3520543,"mow");
		
//		Friends
//		userId		int(11)
//		source		int(11)	
//		cible		int(11)	
//		timestamp	timestamp
//
//		Sessions
//		idUser		int(11)
//		timestamp	timestamp 
//		key_u		varchar(32)
//		isRoot		tinyint(1) (boolean)
//		connect		tinyint(1) (boolean)
//
//		Users
//		id		int(11)	
//		login		varchar(64)
//		pwd		blob
//		prenom		varchar(255)
//		nom		varchar(255)
		
	}
}
