package test;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

public class Test_Message {
	public static void main(String[] args) throws SQLException, JSONException, ClassNotFoundException, UnknownHostException {
	Connection c=bd.Database.getMySqlConnection();
	System.out.println("Add Message: "+servicesClasses.Message.AddMessage("uneclef","monmessage"));
	//System.out.println("Remove Message: "+servicesClasses.Message.RemoveMessage("uneclef",30));
	List<String>l=new ArrayList<String>();
	l.add("35");
	System.out.println("Remove Message: "+servicesClasses.Message.ListMessage(l));
	c.close();
	}
}
