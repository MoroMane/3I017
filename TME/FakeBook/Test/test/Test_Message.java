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
	//System.out.println("Add Message: "+servicesClasses.Message.AddMessage("BAIjpgGzeTkczqYFuZZgrBYsnPrRreoo","Petit frère n'a qu'un souhait devenir grand"));
	//System.out.println("Add Message: "+servicesClasses.Message.AddMessage("BAIjpgGzeTkczqYFuZZgrBYsnPrRreoo","C'est pourquoi il s'obstine à jouer les sauvages dès l'âge de dix ans"));
	//System.out.println("Add Message: "+servicesClasses.Message.AddMessage("BAIjpgGzeTkczqYFuZZgrBYsnPrRreoo","Devenir adulte avec les infos comme mentor"));
	//System.out.println("Add Message: "+servicesClasses.Message.AddMessage("BAIjpgGzeTkczqYFuZZgrBYsnPrRreoo","C'est éclater les tronches de ceux qui ne sont pas d'accord"));
	
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
