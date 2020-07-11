package com.onlinelibrarymanagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Issuebookpage
 */
@WebServlet("/Issuebookpage")
public class Issuebookpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Issuebookpage() {
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
		
		int edit;
		String bookID;
		String memberID;

		try {
			edit = (int) request.getAttribute("Edit");
		} catch (Exception e) {
			edit = 0;
		}
		if (edit == 1) {
			bookID = (String)request.getAttribute("BookID");
			memberID = (String) request.getAttribute("MemberID");
			request.setAttribute("Edit", "Edit");
			request.setAttribute("BookID", bookID);
			request.setAttribute("MemberID", memberID);
		} else {
			request.setAttribute("Edit", "NotEdit");
			request.setAttribute("BookID", "");
			request.setAttribute("MemberID", "");
		}
		
		request.getRequestDispatcher("addissue.jsp").forward(request,response);
		doGet(request, response);
	}

}
