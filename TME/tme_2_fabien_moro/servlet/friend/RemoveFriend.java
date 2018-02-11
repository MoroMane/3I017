package friend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class RemoveFriend 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		String key=request.getParameter("key");
		String id_friend=request.getParameter("id_friend");
		JSONObject ret=new JSONObject();
		try
		{
			ret=servicesClasses.Friend.RemoveFriend(key,id_friend);
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
