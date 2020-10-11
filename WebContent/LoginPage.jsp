<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
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
	<div class="d-flex justify-content-center h-100" style="margin-top: 150px">
		<div class="card">
			<div class="card-header bg-primary text-white" align="center">
				<h3 style="font-family: arial; justify-content: center; ">User Login</h3>
			</div>
			<div class="card-body">
				<form action="UserLoginServlet" method="post">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="email" name="useremail" autofocus required class="form-control" placeholder="E-mail">
						
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" name="userpassword" required class="form-control" placeholder="Password">
					</div>
					<div class="row align-items-center remember" style="margin-left: 1px">
						<input type="checkbox">Remember Me
					</div>
					<div class="bg-danger text-white" align="center">
 					 <%
  						if(request.getAttribute("errormsg") != null)
  						{
  							out.print(request.getAttribute("errormsg"));
  						}
  					%>
  					</div>
  					<br/>
					<div class="form-group">
						<button class="btn btn-lg btn-outline-success btn-block" type="submit">Sign in</button>
					</div>
				</form>
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					Don't have an account?<a href="SignUp.jsp">Sign Up</a>
				</div>
				<div class="d-flex justify-content-center">
					<a href="#">Forgot your password?</a>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>