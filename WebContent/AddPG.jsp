<%@page import="sss.pgs.model.OwnerDetailsInfo"%>
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
<div style="color: red; font-weight: bold" align="center">
	<%
  		if(request.getAttribute("regconfirmmsg") != null)
  		{
  			out.print(request.getAttribute("regconfirmmsg"));
  		}
	
	    OwnerDetailsInfo ownerobj = (OwnerDetailsInfo) session.getAttribute("owner");
  	%>
</div>
					
	<div class="row" style="margin-top: 100px;">
		<div class="col-md-6 col-sm-8 mx-auto">
			<div class="card">
				<div class="card-header bg-success text-white" align="center">
					<h3 style="font-family: arial; justify-content: center;">Add Property</h3>
				</div>
				<div class="card-body">
					<form action="PGRegistrationServlet" method="post">
					<input type="hidden" name="owneremail" value="<%=ownerobj.getOwneremail()%>" />
						<div class="input-group form-group">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-file-signature"></i></span>
							</div>
							<input type="text" name="pgname" required class="form-control" placeholder="PG's Name">
						</div>
						<div class="input-group form-group">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-globe-asia"></i></span>
							</div>
							<input type="text" name="pgstate" required class="form-control" placeholder="Enter the state">
						</div>
						<div class="input-group form-group">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-map"></i></span>
							</div>
							<input type="text" name="pgdistrict" required class="form-control" placeholder="Enter the district">
						</div>
						<div class="input-group form-group">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-road"></i></span>
							</div>
							<input type="text" name="pglocation" required class="form-control" placeholder="Enter the location">
						</div>
						<div class="input-group form-group">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-map-marker-alt"></i></span>
							</div>
							<input type="text" name="pglandmark" class="form-control" placeholder="Enter a landmark">
						</div>
						<div class="input-group form-group">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-home"></i></span>
							</div>
							<input type="text" name="pgaddress" required class="form-control" placeholder="Enter the full address">
						</div>
						<div class="input-group form-group">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-map-marked-alt"></i></span>
							</div>
							<input type="text" name="pgdispin" required class="form-control" placeholder="PIN Code">
						</div>
						<label for="PGType" >Bed Type</label>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="pgtype" value="SingleBed">
							<label class="form-check-label" for="rodio1">SingleBed</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="pgtype" value="DoubleBed">
							<label class="form-check-label" for="rodio2">DoubleBed</label>	
						</div>
						<br/>
						<label for="PGTypeac">Air-Conditioned</label>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="pgtypac" value="AC">
							<label class="form-check-label" for="rodio1">Yes</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="pgtypac" value="Non AC">
							<label class="form-check-label" for="rodio2">No</label>	
						</div>
						<div class="input-group form-group">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-rupee-sign"></i></span>
							</div>
							<input type="number" name="pgcost" required class="form-control" placeholder="Cost Per Person">
						</div>
						<div class="input-group form-group">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-users"></i></span>
							</div>
							<input type="number" name="pgcapacity" required class="form-control" placeholder="Total Capacity">
						</div>
						<div class="form-group">
						<button class="btn btn-lg btn-outline-dark btn-block" type="submit">Submit</button>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>