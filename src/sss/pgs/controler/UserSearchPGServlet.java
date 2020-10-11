package sss.pgs.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sss.pgs.dao.PGDAOLogic;
import sss.pgs.model.PGDetailsInfo;

@WebServlet("/UserSearchPGServlet")
public class UserSearchPGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserSearchPGServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pgstate = request.getParameter("pgstate");
		String pgdistrict = request.getParameter("pgdistrict");
		String pglocation = request.getParameter("pglocation");
		PGDAOLogic pgdaoobj = new PGDAOLogic();
		
		ArrayList<PGDetailsInfo> pglist = pgdaoobj.searchPGRecordUser(pgstate,pgdistrict,pglocation);
		
		request.setAttribute("searchrecord", pglist);
		RequestDispatcher rd = request.getRequestDispatcher("UserAfterLogin.jsp");
		rd.forward(request, response);}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
