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

	<div class="main-body">

		<%
	String[] imageSrc={"/OnlineLibraryManagement/images/add-book.svg",
			"/OnlineLibraryManagement/images/book-list.svg",
			"/OnlineLibraryManagement/images/member-list.svg",
			"/OnlineLibraryManagement/images/add-member.svg",
			"/OnlineLibraryManagement/images/issue-book.svg",
			"/OnlineLibraryManagement/images/issue-book.svg"};
	String[] buttonText={"Add Book",
			"Book List",
			"Member List",
			"Add Member",
			"Issue Book",
			"Issue List"};
	String[] action={"Addbookpage",
			"Booklist",
			"Memberlist",
			"Addmemberpage",
			"Issuebookpage",
			"Issuelist"};
	int a=1;
	%>

		<%
	for(int i=0; i<buttonText.length;i++){
	%>
		<div class="card text-center m-2" style="width: 18rem;">
			<img class="card-img-top mx-auto" src="<%=imageSrc[i]%>">
			<div class="card-body">
				<form action="<%=action[i]%>" method="Post">
					<input type="submit" class="btn btn-primary" value="<%=buttonText[i]%>">
				</form>
			</div>
		</div>

		<%
	}
	%>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>