package test;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import com.mongodb.DBCollection;

public class Test_Message {
	public static void main(String[] args) throws SQLException, JSONException, ClassNotFoundException, UnknownHostException {
	DBCollection c=bd.Database.getCollection("message");
	System.out.println("Add Message: "+servicesClasses.Message.AddMessage("BAIjpgGzeTkczqYFuZZgrBYsnPrRreoo","test2").toString());
	//System.out.println("Remove Message: "+servicesClasses.Message.RemoveMessage("uneclef",30));
	//List<String>l=new ArrayList<String>();
	//l.add("35");
	//System.out.println("Remove Message: "+servicesClasses.Message.ListMessage(l));
	}
}
