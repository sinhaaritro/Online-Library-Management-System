package com.onlinelibrarymanagement;

import java.sql.*;

public class Database {
	Connection con=null;
	ResultSet rs = null;
	Statement st = null;
	PreparedStatement pst = null;	
	String dbURL = "jdbc:oracle:thin:@localhost:1521/pdb_olm";
	String dbUserName = "libm";
	String dbPassword ="libm";
	
	public void connect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void disconnect() {
		try {
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkAdmin(Admin logging) {
		try {
			String query = "select * from t_admin where t_admin.admin_id='"+logging.adminId +"' and t_admin.password='"+logging.password+"'";
			
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			if(rs.next()==false) {
				return false;
			}else {
				return true;
			}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ResultSet bookList() {
		String query = "select * from t_book";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void addBook(Book book) {
		String query = "insert into t_book (book_id,book_name) values (?,?)";
		
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, book.bookID);
			pst.setString(2, book.bookName);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeBook(String bookID) {
		String query = "delete from t_book where book_id=?";
		
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, bookID);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet searchBook(String bookID) {
		String query = "select * from t_book where book_id=?";
		
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, bookID);
			rs = pst.executeQuery();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public void updateBook(String bookID, Book book) {
		String query = "update t_book set book_id = ?, book_name = ? where book_id=?";
		
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, book.bookID);
			pst.setString(2, book.bookName);
			pst.setString(3, bookID);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Member
	public ResultSet memberList() {
		String query = "select * from t_member";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void addMember(Member member) {
		String query = "insert into t_member (member_id,member_name) values (?,?)";
		
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, member.memberID);
			pst.setString(2, member.memberName);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeMember(String memberID) {
		String query = "delete from t_member where member_id=?";
		
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, memberID);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet searchMember(String memberID) {
		String query = "select * from t_member where member_id=?";
		
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, memberID);
			rs = pst.executeQuery();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public void updateMember(String memberID, Member member) {
		String query = "update t_member set member_id = ?, member_name = ? where member_id=?";
		
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, member.memberID);
			pst.setString(2, member.memberName);
			pst.setString(3, memberID);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Issue
	public ResultSet issueList() {
		String query = "select t_book.*, t_member.* from t_book,t_member where t_book.issued is not null and t_book.issued=t_member.member_id";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void addIssue(String bookID, String memberID) {
		String query = "update t_book set issued = '"+memberID+"' where book_id='"+bookID+"'";
		
		try {
			//pst = con.prepareStatement(query);
			//pst.setString(1, memberID);
			//pst.setString(2, bookID);
			st = con.createStatement();
			//pst.executeUpdate();
			rs = st.executeQuery(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateIssue(String bookID, String memberID) {
		String query = "update t_book set issued = ? where book_id=?";
		try {
			System.out.println(query);
			pst = con.prepareStatement(query);
			pst.setString(1, memberID);
			pst.setString(2, bookID);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteIssue(String bookID) {
		String query = "update t_book set issued = null where book_id=?";
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, bookID);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}