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
<script>
function tarkista(){
	var kentat=document.getElementsByClassName("kentta");
	var array = Array.from(kentat);
	var msg="Tarkista kaikki kentät"
	var i;

	for(i = 0; i < kentat.length; i++){
		if(kentat[i].value == "")
			document.getElementById("error").innerHTML = msg;
		return false;
	}
	return true;
} 
</script>
</head>
<body>
<%String uname =(String)session.getAttribute("uname");
if(null!=uname){%>
<h2>Muokkaa Ehdokasta</h2>

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

<form action="MuokkaaHelper" method="POST" onsubmit="return tarkista();">

Ehdokas ID					<input class="kentta" type="text" name="id"/><br>
Sukunimi					<input class="kentta" type="text" name="Sukunimi"/><br>
Etunimi						<input class="kentta" type="text" name="Etunimi"/><br>
Puolue						<input class="kentta" type="text" name="Puolue"/><br>
KotiPaikkaKunta				<input class="kentta" type="text" name="Kotipaikkakunta"/><br>
Ikä							<input class="kentta" type="text" name="ikä"/><br>
Miksi Eduskuntaan			<input class="kentta" type="text" name="MiksiEduskuntaan"/><br>
Mitä asioita haluat edistää	<input class="kentta" type="text" name="MitäAsioitaHauluatEdistää"/><br>
Ammatti						<input class="kentta" type="text" name="Ammatti"/><br>
<input type="submit" value='lisaa'/>

</form>
<div id="error"></div>
</div>
</body>
</html>
<% }else{
		response.sendRedirect("http://localhost:8080/index.html");
	} %>