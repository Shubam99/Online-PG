package sss.pgs.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sss.pgs.dao.UserDAOLogic;
import sss.pgs.model.UserDetailsInfo;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserLoginServlet()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String useremail = request.getParameter("useremail");
		String userpassword = request.getParameter("userpassword");
		
		UserDAOLogic daoobj = new UserDAOLogic();
		UserDetailsInfo userobj = daoobj.userLoginCheck(useremail, userpassword);
		
		if(userobj != null)
		{
			System.out.println("Welcome");
			HttpSession session = request.getSession(true);
			session.setAttribute("userinfo", userobj);
			
			RequestDispatcher rd = request.getRequestDispatcher("UserAfterLogin.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("Invalid");
			
			request.setAttribute("errormsg", "Invalid username or password");
			RequestDispatcher rd = request.getRequestDispatcher("LoginPage.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}