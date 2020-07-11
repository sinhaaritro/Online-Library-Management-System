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
	String action = "Addissue";
	String buttontext = "ADD ISSUE";
	String oldbookid = null;
	String oldmemberid = null;
	String readOnly = "";
	String edit = (String)request.getAttribute("Edit");
	if (edit == "Edit"){
		action = "Updateissue";
		buttontext = "UPDATE ISSUE";
		oldbookid = (String)request.getAttribute("BookID");
		oldmemberid = (String)request.getAttribute("MemberID");
		readOnly = "readonly=\"readonly\"";
	}
	%>

	<div class="main-body">
		<div class="col-md-8 order-md-1">
			<h4 class="mb-3">Issue Book</h4>
			<form action="Addissue" method="Post">

				<div class="mb-3">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">Book ID</span>
						</div>
						<input type="text" class="form-control" id="bookid" name="bookid"
							value="<%= request.getAttribute("BookID") %>" <%=readOnly%>
							required>
						<div class="invalid-feedback" style="width: 100%;">Book ID
							is required.</div>
					</div>
				</div>

				<div class="mb-3">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">Member ID</span>
						</div>
						<input type="text" class="form-control" id="memberid"
							name="memberid" value="<%= request.getAttribute("MemberID") %>"
							required>
						<div class="invalid-feedback" style="width: 100%;">Member ID
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