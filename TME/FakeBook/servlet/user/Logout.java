package user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class Logout extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		String key=request.getParameter("key");
		JSONObject ret=new JSONObject();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			ret=servicesClasses.User.Logout(key);
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
