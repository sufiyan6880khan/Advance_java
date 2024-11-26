package Test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet
{

	@Override
   protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
   ServletException,IOException
   {
	   UserBean ub = new UserBean();
	   ub.setuName(req.getParameter("uName"));
	   ub.setpWord(req.getParameter("pWord"));
	   ub.setfName(req.getParameter("fName"));
	   ub.setlName(req.getParameter("lName"));
	   ub.setAddr(req.getParameter("Addr"));
	   ub.setmId(req.getParameter("mId"));
	   ub.setphNo(Long.parseLong(req.getParameter("phNo")));
	   
	   int k = new RegisterDAO().insert(ub);
	   if(k>0) {
		   req.setAttribute("msg", "User registered Successfully...<br>");
		   RequestDispatcher rd = req.getRequestDispatcher("RegSuccess.jsp");
		   rd.forward(req, res);
	   }
	   
   }


}
