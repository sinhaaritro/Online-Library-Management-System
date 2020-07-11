package com.onlinelibrarymanagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addmemberpage
 */
@WebServlet("/Addmemberpage")
public class Addmemberpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addmemberpage() {
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
		Member member = new Member();

		try {
			edit = (int) request.getAttribute("Edit");
		} catch (Exception e) {
			edit = 0;
		}
		if (edit == 1) {
			member = (Member) request.getAttribute("Member");
			request.setAttribute("Edit", "Edit");
			request.setAttribute("MemberID", member.memberID);
			request.setAttribute("MemberName", member.memberName);
		} else {
			request.setAttribute("Edit", "NotEdit");
			request.setAttribute("MemberID", "");
			request.setAttribute("MemberName", "");
		}
		
		request.getRequestDispatcher("addmember.jsp").forward(request,response);
		doGet(request, response);
	}

}
