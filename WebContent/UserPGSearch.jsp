<%@page import="sss.pgs.model.PGDetailsInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PGSystem</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<div align="center">
<form action="UserSearchPGServlet">
	<input type="text" name="pgstate" required placeholder="ENTER STATE" />
	<input type="text" name="pgdistrict" required placeholder="ENTER DISTRICT" />
	<input type="text" name="pglocation" required placeholder="ENTER LOCATION" />
	<input type="submit" value ="SEARCH">
	
	
	
	</form>
	<br/>
	<br/>
		<%
		if(request.getAttribute("searchrecord") != null )
		{
		ArrayList<PGDetailsInfo> pglist = (ArrayList<PGDetailsInfo>) request.getAttribute("searchrecord");
			
			if(pglist.size() > 0)
			{	
		%>
			<table>
				<!-- <caption>ALL PG DETAILS</caption> -->
				<tr>
					<th>PGNAME</th>
					<th>PGSTATE</th>
					<th>PGDISTRICT</th>
					<th>PGLOCATION</th>
					<th>PGLANDMARK</th>
					<th>PGADDRESS</th>
					<th>PGDISPIN</th>
					<th>PGTYPE</th>
					<th>PGTYPAC</th>
					<th>PGCOST</th>
					<th>PGCAPACITY</th>
					<th>OWNEREMAIL</th>
				</tr>
				
				<%
					for(PGDetailsInfo pgobj:pglist)
					{
				%>
					<tr>
						<td><%= pgobj.getPGName()%></td>
						<td><%= pgobj.getPGState()%></td>
						<td><%= pgobj.getPGDistrict()%></td>
						<td><%= pgobj.getPGLocation()%></td>
						<td><%= pgobj.getPGLandmark()%></td>
						<td><%= pgobj.getPGAddress()%></td>
						<td><%= pgobj.getPGDisPin()%></td>
						<td><%= pgobj.getPGType()%></td>
						<td><%= pgobj.getPGTypac()%></td>
						<td><%= pgobj.getPGCost()%></td>
						<td><%= pgobj.getPGCapacity()%></td>
						<td><%=pgobj.getOwnerEmail() %></td>
						<td>
							<a href="UserBookPG.jsp?owneremail=<%=pgobj.getOwnerEmail()%>&pgname=<%=pgobj.getPGName()%>">BOOK</a>
						</td>
					</tr>
				
				<% 
					}//for loop closing 
				%>
			</table>
		
		<%
			}
			else
			{
				out.print("NO RECORD FOUND");
			}
		}
		%>
	
	</div>


</body>
</html>