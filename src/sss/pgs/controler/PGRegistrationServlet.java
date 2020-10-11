package sss.pgs.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sss.pgs.dao.PGDAOLogic;
import sss.pgs.model.PGDetailsInfo;

@WebServlet("/PGRegistrationServlet")
public class PGRegistrationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    
    public PGRegistrationServlet() 
    {
        super();
               
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PGDetailsInfo pgobj = new PGDetailsInfo();
		
		
		pgobj.setPGName(request.getParameter("pgname"));
		pgobj.setPGState(request.getParameter("pgstate"));
		pgobj.setPGDistrict(request.getParameter("pgdistrict"));
		pgobj.setPGLocation(request.getParameter("pglocation"));
		pgobj.setPGLandmark(request.getParameter("pglandmark"));
		pgobj.setPGAddress(request.getParameter("pgaddress"));
		pgobj.setPGDisPin(Integer.parseInt(request.getParameter("pgdispin")));
		pgobj.setPGType(request.getParameter("pgtype"));
		pgobj.setPGTypac(request.getParameter("pgtypac"));
		pgobj.setPGCost(Integer.parseInt(request.getParameter("pgcost")));
		pgobj.setPGCapacity(Integer.parseInt(request.getParameter("pgcapacity")));
		pgobj.setOwnerEmail(request.getParameter("owneremail"));
		PGDAOLogic daoobj = new PGDAOLogic();
		
		
		boolean replyfromdao = daoobj.pgAddition(pgobj);
		
		if(replyfromdao)
		{
		  request.setAttribute("regconfirmmsg", "THANKS FOR REGISTRATION");
		  RequestDispatcher rd = request.getRequestDispatcher("AddPG.jsp");
		  rd.forward(request, response);
		}
		else
			System.out.println("RECORD NOT INSERTED");	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		doGet(request, response);
	}

}
