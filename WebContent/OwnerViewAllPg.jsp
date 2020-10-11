<%@page import="sss.pgs.model.PGDetailsInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<h2> WELCOME </h2>
		<%
			ArrayList<PGDetailsInfo> pglist = (ArrayList<PGDetailsInfo>) request.getAttribute("allpgrecord");
			
			if(pglist.size() > 0)
			{	
		%>
			<table>
				<caption>ALL PG DETAILS</caption>
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
						<td>
								<a href="OwnerDelPGServlet?pgname=<%=pgobj.getPGName()%>"> DELETE </a>
						</td>
					</tr>
				<% 
					}
				%>
			</table>
	
		
		<%
			}
			else
			{
				out.print("NO RECORD FOUND");
			}
		%>
	</div>
	

</body>
</html>