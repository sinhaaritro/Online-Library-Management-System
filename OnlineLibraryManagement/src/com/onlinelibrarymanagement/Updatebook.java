package com.onlinelibrarymanagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updatebook
 */
@WebServlet("/Updatebook")
public class Updatebook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatebook() {
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

		String oldbookID = request.getParameter("oldbookid");
		String bookID = request.getParameter("bookid");
		String bookName = request.getParameter("bookname");
		
		Book book = new Book();
		book.bookID = bookID;
		book.bookName = bookName;
		book.issued = null;
		
		Database db = new Database();
		db.connect();
		db.updateBook(oldbookID,book);
		db.disconnect();
		
		
		request.setAttribute("Edit", 0);
		RequestDispatcher rd = request.getRequestDispatcher("Addbookpage");
		rd.forward(request,response);
		
		
		doGet(request, response);
	}

}
