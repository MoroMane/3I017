package message;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicesTools.serviceRefused;

public class AddMessage extends HttpServlet {	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		String key=request.getParameter("key");
		String message=request.getParameter("message");
		String ret=serviceRefused.serviceRefused("AddMessage Fail", 100).toString();
		try
		{
			ret=servicesClasses.Message.AddMessage(key,message).toString();
		}
		catch(Exception e)
		{
			ret=serviceRefused.serviceRefused("ListMessage Fail", 100).toString();
		}
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print(ret);
	}
}
