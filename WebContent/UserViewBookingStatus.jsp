<%@page import="sss.pgs.model.PGBookingDetailsInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Status</title>
</head>
<body>
<div align="center">
		<h2> WELCOME </h2>
		<%
			ArrayList<PGBookingDetailsInfo> pgblist = (ArrayList<PGBookingDetailsInfo>) request.getAttribute("allpgrecord");
			
			if(pgblist.size() > 0)
			{	
		%>
			<table>
				<caption>ALL BOOKING DETAILS</caption>
				<tr>
					
					<th>NAME</th>
					<th>EMAIL</th>
					<th>BOOKINGID</th>
					<th>OWNEREMAIL</th>
					<th>PGNAME</th>
				</tr>
				
				<%
					for(PGBookingDetailsInfo pgbobj:pgblist)
					{
				%>
					<tr>
						<td><%= pgbobj.getUsername()%></td>
						<td><%= pgbobj.getUseremail()%></td>
						<td><%= pgbobj.getBookid()%></td>
						<td><%= pgbobj.getOwneremail()%></td>
						<td><%= pgbobj.getPgname()%></td>
						
						<td>
							<a href="UserBookingCancelServlet?bookid=<%=pgbobj.getBookid()%>">CANCEL</a>
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