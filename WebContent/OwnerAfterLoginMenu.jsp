<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link rel="shortcut icon" type="image/ico" href="Images/Favicon1.ico">
<meta charset="ISO-8859-1">
<title>PGSystem</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="Homepage.html">PGSystem.</a>	
			<div>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a href="OwnerViewAllPgServlet" class="nav-link">MANAGE ROOMS</a></li>
					<li class="nav-item"><a href="AddPG.jsp" class="nav-link">ADD ROOMS</a></li>
					<li class="nav-item"><a href="OwnerLogoutServlet" class="nav-link">LOGOUT</a></li>
				</ul>
			</div>
		</div>
</nav>
<jsp:include page="Navbar.jsp"></jsp:include>

</body>
</html>