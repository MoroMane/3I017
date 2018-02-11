package message;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class AddComment 
{	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		String key=request.getParameter("key");
		String text=request.getParameter("text");
		JSONObject ret=new JSONObject();
		try
		{
			ret=servicesClasses.Message.AddComment(key,text);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print(ret.toString());
	}
}
