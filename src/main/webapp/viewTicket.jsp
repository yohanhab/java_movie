<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.emovie.db.Provider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2 align=center>
		<font color=black> View Ticket List</font>
	</h2>
	
	<%
		String qry = "select * from ticket";
				
				try{
			Connection conn = Provider.getConnection();
			PreparedStatement ps =  conn.prepareStatement(qry);
			ResultSet rs = ps.executeQuery();
			out.println("");
			
			 out.println("<table align=center border=0 width=800 height=100><tr><th width='100' height='100'>Movie</th><th align='center'>User</th><th align='center'>Date</th><th align=center>Paid</th></tr></h1>");
				       while (rs.next()){
				    	   out.println("<tr><td align=center>"+rs.getString(1)+"</td><td align=center>"+rs.getString(2)+"</td><td align=center>"+rs.getString(3)+"</td><td align=center>"+rs.getString(4)+"</td>");
				    	      
				       }
				}catch(Exception e){
			e.printStackTrace();
				}
		%>

</body>
</html>