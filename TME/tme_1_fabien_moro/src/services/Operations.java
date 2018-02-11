package services;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Operations extends HttpServlet 
{

public Operations(){
 }

double calcul (double a, double b, String operation)
{
	if (operation.equals("addition"))
		return a+b;
	if (operation.equals("multiplication"))
		return a*b;
	if (operation.equals("division"))
		return a/b;
	if (operation.equals("soustraction"))
		return a-b;
	return 0;
}

protected void doGet(HttpServletRequest request,
		 HttpServletResponse response) throws ServletException, IOException {
		 
			response.setContentType(" text / plain " );
			String a = request.getParameter("a");
			String b = request.getParameter("b");
			String c = request.getParameter("c");
			double numa = Integer.parseInt(a);
			double numb = Integer.parseInt(b);
			PrintWriter out = response.getWriter ();
			double z=calcul(numa,numb,c);
			out.println(z);
		 }
}