package sss.pgs.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sss.pgs.dao.PGBookDAOLogic;

@WebServlet("/UserBookingCancelServlet")
public class UserBookingCancelServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public UserBookingCancelServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String bookid = request.getParameter("bookid");
		
		PGBookDAOLogic pgdaoobj = new PGBookDAOLogic();
		boolean replyfromdao = pgdaoobj.cancelBookingByUser(bookid);
		
		if(replyfromdao)
		{
			RequestDispatcher rd = request.getRequestDispatcher("UserViewBookingStatusServlet");
			rd.forward(request, response);
		}
		else
			System.out.println("NO RECORD DELETED");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
