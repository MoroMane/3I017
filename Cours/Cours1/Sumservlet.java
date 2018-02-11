import java .io .*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Hello extends HttpServlet
{
	public void doGet(HttpServletRequest requete, HttpServletResponse reponse) throws ServletException,IOException
	{
		map (String,String) pars= request.getParameterMap();
		int sum;
		if (pars.containsKey("a") && pars.containsKey("b"))
		{
			String valueA=request.getParameter("a");
			String valueB=request.getParameter("b");
			sum=Integer.parseInt(valueA)+Integer.parseInt(valueB);
		}
		else
		{
			sum=0;
		}
		PrintWriter out = reponse.getWriter();
		reponse.setContentType ("text/plain");
		system.out.println (sum);
	}
}