<%@page import="java.util.Random"%>
<%@page import="sss.pgs.model.UserDetailsInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
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
<%
	UserDetailsInfo userobj = (UserDetailsInfo)session.getAttribute("userinfo");
	Random r = new Random();
	int x=r.nextInt(90000);
	String bid="B"+x;
	String owneremail=request.getParameter("owneremail");
	String pgname=request.getParameter("pgname");
	
   
%>
<jsp:include page="Navbar.jsp"></jsp:include>
<div class="container">
	<div class="d-flex justify-content-center h-100" style="margin-top: 100px">
		<div class="card">
			<div class="card-header bg-primary text-white" align="center">
				<h3 style="font-family: arial; justify-content: center;">BOOK YOUR ROOM</h3>
			</div>
			<div class="card-body">
				<form action="UserBookPGServlet">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="far fa-envelope"></i></span>
						</div>
						<input type="email" name="useremail" value = "<%=userobj.getUseremail()%>" required class="form-control" placeholder="Enter your Email">
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="far fa-user"></i></span>
						</div>
						<input type="text" name="username" value = "<%=userobj.getUsername() %>" required class="form-control" placeholder="Enter your Name">
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="text" name="bid" value = "<%=bid %>" class="form-control" >
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="far fa-envelope"></i></span>
						</div>
						<input type="email" name="owneremail" value = "<%=owneremail%>" class="form-control" placeholder="Enter Owner's Email">
					</div>
					
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="far fa-envelope"></i></span>
						</div>
						<input type="text" name="pgname" value = "<%=pgname %>"class="form-control" placeholder="Enter PG Name">
					</div>
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
						<button class="btn btn-lg btn-outline-success btn-block" type="submit">BOOK</button>
					</div>
					<p style="font-size: 10px">By booking up, you agree to owner's <a href="#">Terms & Condition</a>.
				</form>
			</div>
			<div class="card-footer">
				
			</div>
		</div>
	</div>
</div>
</body>
</html>