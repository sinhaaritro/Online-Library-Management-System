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
 * Servlet implementation class Issuelist
 */
@WebServlet("/Issuelist")
public class Issuelist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Issuelist() {
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
		ResultSet rs = db.issueList();
		
		List<Book> bookList = new ArrayList<Book>();
		List<Member> memberList = new ArrayList<Member>();
		
		try {
			while(rs.next()){
				Book book = new Book();
				Member member = new Member();
				
				book.bookID = rs.getString(1);
				book.bookName = rs.getString(2);
				member.memberID = rs.getString(4);
				member.memberName = rs.getString(5);
				
				bookList.add(book);
				memberList.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.disconnect();
		request.setAttribute("booklist", bookList);
		request.setAttribute("memberlist", memberList);
		request.getRequestDispatcher("issuelist.jsp").forward(request,response);	
		doGet(request, response);
	}

}
