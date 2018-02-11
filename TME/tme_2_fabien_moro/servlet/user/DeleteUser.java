package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class DeleteUser 
{	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		String login=request.getParameter("login");
		String name=request.getParameter("name");
		String frame=request.getParameter("frame");
		String pwd=request.getParameter("pwd");
		JSONObject ret=new JSONObject();
		try
		{
			ret=servicesClasses.User.DeleteUser(login,name,frame,pwd);
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
