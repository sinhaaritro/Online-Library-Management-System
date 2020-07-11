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
		int i = 0;
		%>

		<div class="table-responsive m-5">
			<table class="table table-striped table-sm table-hover w-auto">
				<thead class="thead-dark">
					<tr>
						<th>Book ID</th>
						<th>Book Name</th>
						<th>Issued To (Not issued if empty)</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>

					<%
						while (i < bookList.size()) {
					%>

					<tr>
						<td><%=bookList.get(i).getBookID()%></td>
						<td><%=bookList.get(i).getBookName()%></td>
						<td><%=bookList.get(i).getIssued()%></td>
						<td>
							<div class="btn-group" role="group">
								<form action="EditBook" method="Post">
									<input type="hidden" name="bookID"
										value="<%=bookList.get(i).getBookID()%>" readonly="readonly">
									<input type="submit" class="btn btn-warning"
										value="Edit">
								</form>
								&nbsp
								<form action="DeleteBook" method="Post">
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