package message;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicesTools.serviceRefused;

public class RemoveMessage {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		String key=request.getParameter("key");
		String id_message_1=request.getParameter("id_message");
		int id_message=Integer.parseInt(id_message_1);
		String ret=serviceRefused.serviceRefused("RemoveMessage Fail", 100).toString();
		try
		{
			//ret=servicesClasses.Message.RemoveMessage(key,id_message).toString();
		}
		catch(Exception e)
		{
			ret=serviceRefused.serviceRefused("RemoveMessage Fail", 100).toString();
		}
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print(ret);
	}
}
