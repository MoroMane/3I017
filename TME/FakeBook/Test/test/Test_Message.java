package test;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.JSONException;

import com.mongodb.DBCollection;

public class Test_Message {
	public static void main(String[] args) throws SQLException, JSONException, ClassNotFoundException, UnknownHostException {
	DBCollection c=bd.Database.getCollection("message");
	//System.out.println("Add Message: "+servicesClasses.Message.AddMessage("BAIjpgGzeTkczqYFuZZgrBYsnPrRreoo","J'finis pas mes phrases, j'connais pas les points "));
	//System.out.println("Add Message: "+servicesClasses.Message.AddMessage("BAIjpgGzeTkczqYFuZZgrBYsnPrRreoo","J'commence après-demain, j'contrôle pas l'destin "));
	//System.out.println("Add Message: "+servicesClasses.Message.AddMessage("BAIjpgGzeTkczqYFuZZgrBYsnPrRreoo","Rien est assez bien, j'finis jamais rien "));
	//System.out.println("Add Message: "+servicesClasses.Message.AddMessage("BAIjpgGzeTkczqYFuZZgrBYsnPrRreoo","Manquerait la moitié des traits si j'devais t'faire un dessins"));
	
	//System.out.println(servicesClasses.Message.AddMessage("BAIjpgGzeTkczqYFuZZgrBYsnPrRreoo","test22"));
	System.out.println(servicesClasses.Message.ListMessage("BAIjpgGzeTkczqYFuZZgrBYsnPrRreoo","40"));
	//String id_object="5a9e9478e4b00288e238df96";
	//ObjectId objid=new ObjectId(id_object);
	//System.out.println("Remove Message: "+servicesClasses.Message.RemoveMessage("FkTNawQOvZHtYheKubpimZJCxVGPJkbZ",objid));
	//List<String>l=new ArrayList<String>();
	//l.add("35");
	//System.out.println("Remove Message: "+servicesClasses.Message.ListMessage("40",""));
	}
}
