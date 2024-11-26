package Test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
@SuppressWarnings("serial")
@WebServlet("/update")



public class UpdateProfileServlet extends HttpServlet
{
	@Override
	   protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	   ServletException,IOException
	   {
		   Cookie c[] = req.getCookies();
		   if(c==null) {
			   req.setAttribute("msg", "Session Expired...<br>");
			   req.getRequestDispatcher("Msg.jsp").forward(req, res);
		   }else {
			   String fN = c[0].getValue();
			   ServletContext sct = req.getServletContext();
			   UserBean ub = (UserBean)sct.getAttribute("ubean");
			   ub.setAddr(req.getParameter("addr"));
			   ub.setmId(req.getParameter("mid"));
			   ub.setphNo(Long.parseLong(req.getParameter("phno")));
			   int k = new UpdateProfileDAO().update(ub);
			   if(k>0) {
				   req.setAttribute("msg","Profile Updated Successfully...<br>");
				   req.setAttribute("fname", fN);
				   req.getRequestDispatcher("UpdateProfile.jsp").forward(req, res);
			   }
		   }
	   }


}
