package Test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/log")

public class LoginServlet extends HttpServlet
{
	@Override
	  protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	  ServletException,IOException
	  {
		  String uN = req.getParameter("uName");
		  String pW = req.getParameter("pWord");
		  UserBean ub =new LoginDAO().login(uN, pW);
		  if(ub==null) {
			 req.setAttribute("msg", "Invalid Login process...<br>");
			 RequestDispatcher rd = req.getRequestDispatcher("Msg.jsp");
			 rd.forward(req, res);
		  }else {
			  ServletContext sct = req.getServletContext();
			                          //Accessing ServletContext Object reference
			  sct.setAttribute("ubean", ub);
			  Cookie ck = new Cookie("fName",ub.getfName());
			  res.addCookie(ck);//Cookie added to response
			  RequestDispatcher rd = req.getRequestDispatcher("LogSuccess.jsp");
			  rd.forward(req, res);
		  }
	  }

	

}
