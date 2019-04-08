<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,vaalikone.Vaalikone,persist.*"%>
<%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin sivu</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%String uname =(String)session.getAttribute("uname");
if(null!=uname){%>
	
	<h2>Tervetuloa Admin sivulle</h2>

	<div>
	Alla olevasta painikkeesta pääset muokkaamaan ja poistamaan ehdokkaita</div><br>
		<form action=MuokkaaKysymys class="vastausformi">
	  	<input type="submit" id="MuokkaaKysymys" value="Muokkaa kysymys" />
	  	</form>

		<form action="MuokkaaEhdokasta.jsp" class="vastausformi">
		<input type="submit" id="MuokkaaEhdokasta" value="Muokkaa ehdokas" />
		</form>

		<form action="PoistaEhdokas.jsp" class="vastausformi">
		<input type="submit" id="PoistaEhdokas" value="Poista ehdokas" />
		</form>

		<form action="LisaaEhdokas.jsp" class="vastausformi">
		<input type="submit" id="LisaaEhdokas" value="Lisää ehdokas" />
	 	</form>

	 	<form action="KorjaaTietokanta" class="vastausformi">
		<input type="submit" id="KorjaaTietokanta" value="Korjaa tietokanta" />
	 	</form>

	</body>
	</html>
	<% }else{
		response.sendRedirect("http://localhost:8080/index.html");
	} %>
	

