package sss.pgs.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sss.pgs.dao.OwnerDAOLogic;
import sss.pgs.model.OwnerDetailsInfo;


@WebServlet("/OwnerLoginServlet")
public class OwnerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OwnerLoginServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
				String userid = request.getParameter("owneremail");
				String password = request.getParameter("ownerpassword");
				
				
				OwnerDAOLogic daoobj = new OwnerDAOLogic();
				OwnerDetailsInfo ownerobj = daoobj.ownerLoginCheck(userid, password);
				
				if(ownerobj != null)
				{
					System.out.println("WELCOME OWNER");
					HttpSession session = request.getSession(true);
					session.setAttribute("owner", ownerobj);
					
			    RequestDispatcher rd = request.getRequestDispatcher("OwnerAfterLogin.jsp");
					rd.forward(request, response);

				}
				else
				{
					System.out.println("INVALID");
					
					request.setAttribute("errormsg", "INVALID UID OR PASSWORD");
					RequestDispatcher rd = request.getRequestDispatcher("OwnerLogin.jsp");
					rd.forward(request, response);
				}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
