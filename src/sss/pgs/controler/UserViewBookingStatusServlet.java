package sss.pgs.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sss.pgs.dao.PGBookDAOLogic;
import sss.pgs.model.PGBookingDetailsInfo;
import sss.pgs.model.UserDetailsInfo;


@WebServlet("/UserViewBookingStatusServlet")
public class UserViewBookingStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserViewBookingStatusServlet()
    {
        super();    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PGBookDAOLogic pgbdaoobj = new PGBookDAOLogic();
		HttpSession session = request.getSession();
		UserDetailsInfo userobj = (UserDetailsInfo) session.getAttribute("userinfo");
		String useremail = userobj.getUseremail();
		System.out.println(useremail);
		
		ArrayList<PGBookingDetailsInfo> pglist = pgbdaoobj.fetchAllPGBookRecord(useremail);
		
		request.setAttribute("allpgrecord", pglist);
		RequestDispatcher rd = request.getRequestDispatcher("UserViewBookingStatus.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
