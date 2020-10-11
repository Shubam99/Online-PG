package sss.pgs.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sss.pgs.dao.OwnerDAOLogic;
import sss.pgs.model.OwnerDetailsInfo;


@WebServlet("/OwnerRegistrationServlet")
public class OwnerRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OwnerRegistrationServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		OwnerDetailsInfo oobj = new OwnerDetailsInfo();
		
		
		oobj.setOwnername(request.getParameter("ownername"));
		oobj.setOwneremail(request.getParameter("owneremail"));
		oobj.setOwnermobile(request.getParameter("ownermobile"));
		oobj.setOwnerpassword(request.getParameter("ownerpassword"));
		
		
		OwnerDAOLogic daoobj = new OwnerDAOLogic();
		
		
		boolean replyfromdao = daoobj.ownerRegistration(oobj);
		
		if(replyfromdao)
		{
		  request.setAttribute("regconfirmmsg", "THANKS FOR REGISTRATION");
		  RequestDispatcher rd = request.getRequestDispatcher("OwnerRegisteration.jsp");
		  rd.forward(request, response);
		}
		else
			System.out.println("RECORD NOT INSERTED");
	}
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
