package com.onlinelibrarymanagement;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Memberlist
 */
@WebServlet("/Memberlist")
public class Memberlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Memberlist() {
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

		Database db = new Database();
		db.connect();
		ResultSet rs = db.memberList();
		
		List<Member> memberList = new ArrayList<Member>();
		
		try {
			while(rs.next()){
				Member member = new Member();
				member.memberID = rs.getString(1);
				member.memberName = rs.getString(2);
				
				memberList.add(member);				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.disconnect();
		request.setAttribute("memberlist", memberList);		
		request.getRequestDispatcher("memberlist.jsp").forward(request,response);
		doGet(request, response);
	}

}
