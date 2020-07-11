package com.onlinelibrarymanagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addissue
 */
@WebServlet("/Addissue")
public class Addissue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addissue() {
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

		
		String bookID = request.getParameter("bookid");
		String memberID = request.getParameter("memberid");
		
		Database db = new Database();
		db.connect();
		db.addIssue(bookID,memberID);
		db.disconnect();
		
		request.setAttribute("Edit", 0);
		RequestDispatcher rd = request.getRequestDispatcher("Issuebookpage");
		rd.forward(request,response);
		doGet(request, response);
	}

}
