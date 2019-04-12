<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="vaalikone.PoistaHandler"%>
<%@page import="persist.Vastaukset"%>
<%@page import="java.util.List"%>
<%@page import="persist.Ehdokkaat"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.PrintWriter" %>

<%String uname =(String)session.getAttribute("uname");
if(null!=uname){%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>>Poista Ehdokas</title>
<link id="theme" href="style.css" rel="stylesheet" type="text/css">
<script src="skript.js"></script>
<script>
function tarkista(){
	var del=document.getElementById("pst").value;
	var msg="kenttä ei saa olla tyhjä"
	if (del.length<=0){
		document.getElementById("error").innerHTML = msg;
		return false;
	}
	return true;
}
</script>
</head>
<body>
<h2>Poista Ehdokas</h2>

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
	iiii.print("<div id='wrapper'>");
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
<form action="PoistaHandler" method="POST" onsubmit="return tarkista();">

Ehdokas ID<input id="pst" type="text" name="poista"/><br>
<input type="submit" value='delete'/>

</form>
<div id="error">

</div>
</body>
</html>
<% }else{
		response.sendRedirect("http://localhost:8080/index.html");
	} %>
