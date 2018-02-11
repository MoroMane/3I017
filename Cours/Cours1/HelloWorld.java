import java .io .*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Hello extends HttpServlet
{
	public void doGet (HttpServletRequest requete, HttpServletResponse reponse) throws ServletException,IOException
	{
		reponse.setContentType ("text/plain");
		PrintWriter out = reponse.getWriter ();
		system.out.println ("Hello , hello !!!! ");
	}
}