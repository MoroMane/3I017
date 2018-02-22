package user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class CreateUser extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		String login=request.getParameter("login");
		String name=request.getParameter("name");
		String fname=request.getParameter("fname");
		String pwd=request.getParameter("pwd");
		JSONObject ret=new JSONObject();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			ret=servicesClasses.User.CreateUser(login,pwd,fname,name);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.print(ret);
	}
}
