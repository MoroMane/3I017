package message;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.mongodb.BasicDBObject;

import servicesTools.serviceRefused;

@SuppressWarnings("serial")
public class ListMessage extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		String key=request.getParameter("key");
		String id_user=request.getParameter("id_user");
		BasicDBObject ret = new BasicDBObject();
		//JSONObject ret=new JSONObject();
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			ret=servicesClasses.Message.ListMessage(key,id_user);
		}
		catch(Exception e)
		{
			//ret=serviceRefused.serviceRefused("ListMessage Fail", 100);
		}
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print(ret.toString());
	}

}
