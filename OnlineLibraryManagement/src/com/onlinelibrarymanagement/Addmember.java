package com.onlinelibrarymanagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addmember
 */
@WebServlet("/Addmember")
public class Addmember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addmember() {
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
		
		
		String memberID = request.getParameter("memberid");
		String memberName = request.getParameter("membername");
		
		Member member = new Member();
		member.memberID = memberID;
		member.memberName = memberName;
		
		Database db = new Database();
		db.connect();
		db.addMember(member);
		db.disconnect();
		
		request.setAttribute("Edit", 0);
		RequestDispatcher rd = request.getRequestDispatcher("Addmemberpage");
		rd.forward(request,response);
		doGet(request, response);
	}

}
