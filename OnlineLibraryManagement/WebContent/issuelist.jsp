<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.onlinelibrarymanagement.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Library Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body class="background-offwhite">
	<%
		if (session.getAttribute("id") == null) {

		response.sendRedirect("adminlogin.jsp");

	}
	%>
	<jsp:include page="navbar.jsp" />

	<div class="main-body">
		<h2>Book List</h2>

		<%
			List<Book> bookList = (List<Book>) request.getAttribute("booklist");
			List<Member> memberList = (List<Member>) request.getAttribute("memberlist");
		int i = 0;
		%>

		<div class="table-responsive m-5">
			<table class="table table-striped table-sm table-hover w-auto">
				<thead class="thead-dark">
					<tr>
						<th>Member ID</th>
						<th>Member Name</th>
						<th>Book ID</th>
						<th>Book Name</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>

					<%
						while (i < bookList.size()) {
					%>

					<tr>
						<td><%=memberList.get(i).getMemberID()%></td>
						<td><%=memberList.get(i).getMemberName()%></td>
						<td><%=bookList.get(i).getBookID()%></td>
						<td><%=bookList.get(i).getBookName()%></td>
						<td>
							<div class="btn-group" role="group">
								<form action="EditIssue" method="Post">
									<input type="hidden" name="bookID"
										value="<%=bookList.get(i).getBookID()%>" readonly="readonly">
									
									<input type="hidden" name="memberID"
										value="<%=memberList.get(i).getMemberID()%>" readonly="readonly">
									<input type="submit" class="btn btn-warning"
										value="Update">
								</form>
								&nbsp
								<form action="DeleteIssue" method="Post">
									<input type="hidden" name="bookID"
										value="<%=bookList.get(i).getBookID()%>" readonly="readonly">
									<input type="submit" class="btn btn-danger" value="Delete">
								</form>
							</div>
						</td>
					</tr>
					<%
						i++;
					}
					%>

				</tbody>
			</table>
		</div>
	</div>

	<jsp:include page="footer.jsp" />


</body>
</html>