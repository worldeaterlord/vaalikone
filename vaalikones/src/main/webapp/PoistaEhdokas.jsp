<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="vaalikone.PoistaHandler"%>
<%@page import="persist.Vastaukset"%>
<%@page import="java.util.List"%>
<%@page import="persist.Ehdokkaat"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>>Poista Ehdokas</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%String uname =(String)session.getAttribute("uname");
if(null!=uname){%>
<h2>Poista Ehdokas</h2>
<div>
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
		<th><%iiii.print(rs.getInt("EHDOKAS_ID")+ "\n");%></th>
		</tr>
		<tr>
		<th><%iiii.print(rs.getString("SUKUNIMI")+ "\n");%></th>
		</tr>
		<tr>
		<th><%iiii.print(rs.getString("ETUNIMI")+ "\n" + "<br>"); %></th>
		</tr>
			<%
	}
	%>
		<%
		stmt.close();
}
	
 catch (Exception e) {
}

%>

<form action="PoistaHandler" method="POST">

Ehdokas ID<input type="text" name="poista"/><br>
<input type="submit" value='delete'/>

</form>
</div>



</body>
</html>
<% }else{
		response.sendRedirect("http://localhost:8080/index.html");
	} %>