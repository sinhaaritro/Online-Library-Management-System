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
 * Servlet implementation class Booklist
 */
@WebServlet("/Booklist")
public class Booklist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Booklist() {
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
		ResultSet rs = db.bookList();
		
		List<Book> bookList = new ArrayList<Book>();
		
		try {
			while(rs.next()){
				Book book = new Book();
				book.bookID = rs.getString(1);
				book.bookName = rs.getString(2);
				if(rs.getString(3)==null)
					book.issued = "Not Issued";
				else
					book.issued = rs.getString(3);
				
				bookList.add(book);				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.disconnect();
		request.setAttribute("booklist", bookList);		
		request.getRequestDispatcher("booklist.jsp").forward(request,response);
		doGet(request, response);
	}

}
