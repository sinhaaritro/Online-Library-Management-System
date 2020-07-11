package com.onlinelibrarymanagement;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditMember
 */
@WebServlet("/EditMember")
public class EditMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMember() {
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

		String memberID = request.getParameter("memberID");
		
		Member member = new Member();
		Database db = new Database();
		db.connect();
		ResultSet rs = db.searchMember(memberID);
		try {
			while(rs.next()){
				member.memberID = rs.getString(1);
				member.memberName = rs.getString(2);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.disconnect();
		
		request.setAttribute("Member", member);
		request.setAttribute("Edit", 1);
		RequestDispatcher rd = request.getRequestDispatcher("Addmemberpage");
		rd.forward(request,response);
		
		doGet(request, response);
	}

}
