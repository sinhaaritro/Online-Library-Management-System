package com.onlinelibrarymanagement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class adminlogin
 */
@WebServlet("/adminlogin")
public class adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String adminID = request.getParameter("id");
		String adminPassword = request.getParameter("pass");
		
		Admin logging = new Admin();
		logging.adminId = adminID;
		logging.password = adminPassword;
		
		Database db = new Database();
		db.connect();
		boolean verifyLogin = db.checkAdmin(logging);
		db.disconnect();
		System.out.println("Login"+verifyLogin);
		
		if(verifyLogin) {			
			HttpSession session = request.getSession();
			session.setAttribute("id", adminID);
			response.sendRedirect("index.jsp");
			
		} else {
			response.sendRedirect("adminlogin.jsp");
		}
		
		doGet(request, response);
	}

}
