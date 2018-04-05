package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@SuppressWarnings("serial")
public class Login extends HttpServlet
{	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		String login=request.getParameter("login");
		String pwd=request.getParameter("pwd");
		JSONObject ret=new JSONObject();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			ret=servicesClasses.User.Login(login,pwd);
		}
		catch(Exception e)		{
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		//response.addHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter();
		out.print(ret.toString());
	}
}
	
