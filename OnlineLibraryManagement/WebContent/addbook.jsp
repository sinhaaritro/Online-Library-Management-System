<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		if(session.getAttribute("id")==null){
			
			response.sendRedirect("adminlogin.jsp");
			
		}
	%>
	<jsp:include page="navbar.jsp" />

	<%
	String action = "Addbook";
	String buttontext = "ADD BOOK";
	String oldbookid = null;
	String edit = (String)request.getAttribute("Edit");
	if (edit == "Edit"){
		action = "Updatebook";
		buttontext = "UPDATE BOOK";
		oldbookid = (String)request.getAttribute("BookID");
	}
	%>
	<div class="main-body">
		<div class="col-md-8 order-md-1">
			<h4 class="mb-3">Add Book</h4>

			<form action="<%=action%>" method="Post">
				<input type="hidden" class="form-control" name="oldbookid"
					id="oldbookid" value="<%=oldbookid%>" readonly="readonly">
				<div class="mb-3">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">Book ID</span>
						</div>
						<input type="text" class="form-control" name="bookid" id="bookid"
							value="<%= request.getAttribute("BookID") %>" required>
						<div class="invalid-feedback" style="width: 100%;">Book ID
							is required.</div>
					</div>
				</div>

				<div class="mb-3">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">Book Name</span>
						</div>
						<input type="text" class="form-control" name="bookname"
							id="bookname" value="<%= request.getAttribute("BookName") %>"
							required>
						<div class="invalid-feedback" style="width: 100%;">Book name
							is required.</div>
					</div>
				</div>


				<hr class="mb-4">
				<button class="btn btn-primary btn-lg btn-block" type="submit">
					<%=buttontext%>
				</button>
			</form>
		</div>
	</div>

	<jsp:include page="footer.jsp" />


</body>
</html>