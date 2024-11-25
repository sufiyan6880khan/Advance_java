package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/av")
public class AverageServlet extends GenericServlet
{
	@Override
    public void service(ServletRequest req,ServletResponse res) throws ServletException,  IOException
    {

    	int x = Integer.parseInt(req.getParameter("v1"));
    	int y = Integer.parseInt(req.getParameter("v2"));
    	float z = (float)(x+y)/2;
    	PrintWriter pw = res.getWriter();
    	res.setContentType("text/html");
    	pw.println("Average : "+z+"<br>");
    	RequestDispatcher rd = req.getRequestDispatcher("choice.html");
    	rd.include(req, res);

    }


}
