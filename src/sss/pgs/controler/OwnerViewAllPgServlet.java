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

import sss.pgs.dao.PGDAOLogic;
import sss.pgs.model.OwnerDetailsInfo;
import sss.pgs.model.PGDetailsInfo;

@WebServlet("/OwnerViewAllPgServlet")
public class OwnerViewAllPgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OwnerViewAllPgServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PGDAOLogic pgdaoobj = new PGDAOLogic();
		HttpSession session = request.getSession();
		OwnerDetailsInfo ownerobj = (OwnerDetailsInfo) session.getAttribute("owner");
		String owneremail = ownerobj.getOwneremail();
		System.out.println(owneremail);
		
		ArrayList<PGDetailsInfo> pglist = pgdaoobj.fetchAllPGRecord(owneremail);
		
		request.setAttribute("allpgrecord", pglist);
		RequestDispatcher rd = request.getRequestDispatcher("OwnerViewAllPg.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
