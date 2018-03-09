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

import servicesTools.serviceRefused;

@SuppressWarnings("serial")
public class ListMessage extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		String key=request.getParameter("key");
		String list_id_user=request.getParameter("list_id_user");
		List<String> myList = new ArrayList<String>(Arrays.asList(list_id_user.split(",")));
		JSONObject ret=new JSONObject();
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//ret=servicesClasses.Message.ListMessage(key,myList);
		}
		catch(Exception e)
		{
			ret=serviceRefused.serviceRefused("ListMessage Fail", 100);
		}
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print(ret.toString());
	}

}
