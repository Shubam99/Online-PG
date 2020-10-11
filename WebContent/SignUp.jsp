<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
<link rel="shortcut icon" type="image/ico" href="Images/Favicon1.ico">
<title>PGSystem</title>
<style>
	body
	{
		background-image: url("Images/03.jpg");
		background-repeat: no-repeat;
		background-size: cover;
	}
	</style>
</head>
<body>
<jsp:include page="Navbar.jsp"></jsp:include>
<div class="container">
	<div class="d-flex justify-content-center h-100" style="margin-top: 100px">
		<div class="card">
			<div class="card-header bg-primary text-white" align="center">
				<h3 style="font-family: arial; justify-content: center;">User Registration</h3>
			</div>
			<div class="card-body">
				<form action="UserRegistrationServlet">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="far fa-user"></i></span>
						</div>
						<input type="text" name="username" required class="form-control" placeholder="Enter your name">
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="far fa-envelope"></i></span>
						</div>
						<input type="email" name="usermail" required class="form-control" placeholder="Enter your e-mail">
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-mobile-alt"></i></span>
						</div>
						<input type="text" name="usermobile" required class="form-control" placeholder="Enter your mobile number">
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" name="userpassword" class="form-control" placeholder="Enter your password">
					</div>
					<div style="color: red; font-weight: bold">
  						<%
  							if(request.getAttribute("regconfirm") != null)
  							{
  								out.print(request.getAttribute("regconfirm"));
  							}
  						%>
  					</div>
					<div class="form-group">
						<button class="btn btn-lg btn-outline-danger btn-block" type="submit">Sign Up</button>
					</div>
					<p style="font-size: 10px">By signing up, you agree to our <a href="#">Terms of use</a> and <a href="#">Privacy policy</a>.
				</form>
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					Already have an account?<a href="LoginPage.jsp">Sign in</a>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>