<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Online Library Management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div class="form-signin-container container">
        <div class="form-signin-container-image">
            <img src="/OnlineLibraryManagement/images/loginimage.jpg">
        </div>
        
        <div class="form-signin-container-image text-center">
            
            <form action="adminlogin" method="post" class="form-signin">
                <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
                <br>
                <label for="inputID" class="sr-only">ID</label>
                <input type="text" name="id" id="inputID" class="form-control" placeholder="ID" required autofocus>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" name="pass" id="inputPassword" class="form-control" placeholder="Password" required>
                <br>
                <input class="btn btn-lg btn-primary btn-block" type="submit" value="Sign in">
            </form>
        </div>
    </div>
    <br>

</body>

</html>