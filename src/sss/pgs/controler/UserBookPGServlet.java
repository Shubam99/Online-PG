package sss.pgs.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sss.pgs.dao.PGBookDAOLogic;
import sss.pgs.model.PGBookingDetailsInfo;


@WebServlet("/UserBookPGServlet")
public class UserBookPGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserBookPGServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PGBookingDetailsInfo pgbobj = new PGBookingDetailsInfo();
		
	
		pgbobj.setUseremail(request.getParameter("useremail"));
		pgbobj.setUsername(request.getParameter("username"));
		pgbobj.setBookid(request.getParameter("bid"));
		pgbobj.setOwneremail(request.getParameter("owneremail"));
		pgbobj.setPgname(request.getParameter("pgname"));
		
		
		PGBookDAOLogic daoobj = new PGBookDAOLogic();
		boolean replyfromdao = daoobj.pgBooking(pgbobj);
		
		if(replyfromdao)
		{
			request.setAttribute("regconfirm", "Booking Successfull!");
			RequestDispatcher rd = request.getRequestDispatcher("UserBookPG.jsp");
			rd.forward(request, response);
		}
		else
			System.out.println("BOOKING FAILED");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
