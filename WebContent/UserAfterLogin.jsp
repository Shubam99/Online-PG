<%@page import="sss.pgs.model.UserDetailsInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PGSystem</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" type="image/ico" href="Images/Favicon1.ico">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="Homepage.html">PGSystem.</a>	
			<div>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a href="UserViewBookingStatusServlet" class="nav-link">VIEW BOOKING STATUS</a></li>
					<li class="nav-item"><a href="UserLogoutServlet" class="nav-link">LOGOUT</a></li>
					<li class="nav-item"><a href="AboutUs.html" class="nav-link">ABOUT US</a></li>
					<li class="nav-item"><a href="#" class="nav-link">CONTACT US</a></li>
				</ul>
			</div>
		</div>
</nav>
<div align="center">

	<%
	UserDetailsInfo userobj = (UserDetailsInfo)session.getAttribute("userinfo");
%>
</div>
	<div align="center" style="color: #FD3F00; font-weight: bold;">
	<h1>WELCOME &nbsp;    <%=userobj.getUsername() %></h1>
</div>
	<jsp:include page="UserPGSearch.jsp"></jsp:include>
	
</body>
</html>