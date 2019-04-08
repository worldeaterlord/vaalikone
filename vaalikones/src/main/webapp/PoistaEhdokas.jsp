<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="vaalikone.PoistaHandler"%>
<%@page import="persist.Vastaukset"%>
<%@page import="java.util.List"%>
<%@page import="persist.Ehdokkaat"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>>Poista Ehdokas</title>
</head>
<body>

<div>
<form>
<table>
<%
try {
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost/vaalikone";
	String username="root";
	String password="";
	String query = "SELECT * FROM ehdokkaat";
	Connection con = DriverManager.getConnection(url,username,password);
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(query);
	PrintWriter iiii = response.getWriter();
	while (rs.next()) {
		%>
		<tr>
		<td><%iiii.print(rs.getInt("EHDOKAS_ID"));%></td>
		<td><%iiii.print(rs.getString("SUKUNIMI"));%></td>
		<td><%iiii.print(rs.getString("ETUNIMI")); %></td>
		</tr>
			<%
	}
	%>
		</table>
		<%
		stmt.close();
}
	
 catch (Exception e) {
}

%>
</form>

<form action="PoistaHandler" method="POST">

Ehdokas ID<input type="text" name="poista"/><br>
<input type="submit" value='delete'/>

</form>
</div>



</body>
</html>