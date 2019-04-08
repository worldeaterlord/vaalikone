<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="vaalikone.MuokkaaHelper"%>
<%@page import="persist.Vastaukset"%>
<%@page import="java.util.List"%>
<%@page import="persist.Ehdokkaat"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>>Muokkaa Ehdokasta</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%String uname =(String)session.getAttribute("uname");
if(null!=uname){%>
<h2>Muokkaa Ehdokasta</h2>
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

<form action="MuokkaaHelper" method="POST">

Ehdokas ID<input type="text" name="id"/><br>
Sukunimi<input type="text" name="Sukunimi"/><br>
Etunimi<input type="text" name="Etunimi"/><br>
Puolue<input type="text" name="Puolue"/><br>
KotiPaikkaKunta<input type="text" name="Kotipaikkakunta"/><br>
Ikä<input type="text" name="ikä"/><br>
Miksi Eduskuntaan<input type="text" name="MiksiEduskuntaan"/><br>
Mitä asioita haluat edistää<input type="text" name="MitäAsioitaHauluatEdistää"/><br>
Ammatti<input type="text" name="Ammatti"/><br>
<input type="submit" value='lisaa'/>

</form>
</div>



</body>
</html>
<% }else{
		response.sendRedirect("http://localhost:8080/index.html");
	} %>