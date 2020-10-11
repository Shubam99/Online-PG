package sss.pgs.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sss.pgs.dao.UserDAOLogic;
import sss.pgs.model.UserDetailsInfo;

@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public UserRegistrationServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserDetailsInfo userobj = new UserDetailsInfo();
		
		userobj.setUsername(request.getParameter("username"));
		userobj.setUseremail(request.getParameter("usermail"));
		userobj.setUsermobile(request.getParameter("usermobile"));
		userobj.setUserpassword(request.getParameter("userpassword"));
		
		UserDAOLogic daoobj = new UserDAOLogic();
		boolean replyfromdao = daoobj.userRegistration(userobj);
		
		if(replyfromdao)
		{
			request.setAttribute("regconfirm", "Registration Successful!");
			RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
			rd.forward(request, response);
		}
		else
			System.out.println("REGISTRATION FAILED");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
