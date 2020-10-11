package sss.pgs.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sss.pgs.dao.PGDAOLogic;


@WebServlet("/OwnerDelPGServlet")
public class OwnerDelPGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OwnerDelPGServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pgname = request.getParameter("pgname");
		
		PGDAOLogic pgdaoobj = new PGDAOLogic();
		boolean replyfromdao = pgdaoobj.PGDelByOwner(pgname);
		
		if(replyfromdao)
		{
			RequestDispatcher rd = request.getRequestDispatcher("OwnerViewAllPgServlet");
			rd.forward(request, response);
		}
		else
			System.out.println("NO RECORD DELETED");

	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
