<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.emovie.db.Provider"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align=center><font color=black>View Users</font></h2>
<%
	String qry="select * from ticket";
	try
	{
		Connection con=Provider.getConnection();
		PreparedStatement stmt=con.prepareStatement(qry);
		ResultSet rs = stmt.executeQuery();
		out.println("");
        out.println("<table align=center border=1 width=800 height=100><tr><th align='center'>Movie</th><th align='center'>Email</th><th align='center'>Date</th><th align='center'>Location</th><th align='center'>Phone Number</th></tr></h1>");
        while ( rs.next()) {
              
              out.println("<tr><td align=center>"+rs.getString(1)+"</td><td align=center>"+rs.getString(2)+"</td><td align=center>"+rs.getString(3)+"</td></td><td align=center>"+rs.getString(5)+"</td></td><td align=center>"+rs.getString(7)+"</td><p/>");
        }
		
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
	}

%>

</body>
</html>