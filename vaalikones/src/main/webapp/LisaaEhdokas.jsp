<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,vaalikone.Vaalikone,persist.*"%>
<%@page import="vaalikone.LisaaHelper"%>
<%@page import="persist.Vastaukset"%>
<%@page import="java.util.List"%>
<%@page import="persist.Ehdokkaat"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lisaa ehdokas sivu</title>
<link id="theme" href="style.css" rel="stylesheet" type="text/css">
<script src="skript.js"></script>
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
if(null!=uname){%><h2>Lisää Ehdokas</h2>



<form>
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
</form>


<form action="LisaaHelper" method="POST" onsubmit="return tarkista();">

Ehdokas ID					<input class="ehdokas" type="text" name="id"/><br>
Sukunimi					<input class="ehdokas" type="text" name="Sukunimi"/><br>
Etunimi						<input class="ehdokas" type="text" name="Etunimi"/><br>
Puolue						<input class="ehdokas" type="text" name="Puolue"/><br>
Kotipaikkakunta				<input class="ehdokas" type="text" name="Kotipaikkakunta"/><br>
Ikä							<input class="ehdokas" type="text" name="ikä"/><br>
Miksi eduskuntaan			<input class="ehdokas" type="text" name="Miksieduskuntaan"/><br>
Mitä asioita haluat edistää	<input class="ehdokas" type="text" name="MitäAsioitaHauluatEdistää"/><br>
Ammatti						<input class="ehdokas" type="text" name="Ammatti"/><br>
<input type="submit" value='lisaa'/>
</form>

<div id="error"></div>
</body>
</html>
<% }else{
		response.sendRedirect("http://localhost:8080/index.html");
	} %>
