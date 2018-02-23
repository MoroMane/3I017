package message;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicesTools.serviceRefused;

public class ListMessage {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		String list_id_user=request.getParameter("list_id_user");
		List<String> myList = new ArrayList<String>(Arrays.asList(list_id_user.split(",")));
		String ret=serviceRefused.serviceRefused("ListMessage Fail", 100).toString();
		try
		{
			ret=servicesClasses.Message.ListMessage(myList).toString();
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
