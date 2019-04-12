<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,vaalikone.Vaalikone,persist.*"%>
<%@ page import="java.io.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin sivu</title>
<link id="theme" href="style.css" rel="stylesheet" type="text/css">
<script src="skript.js"></script>
</head>
<body>
	<%
		String uname = (String) session.getAttribute("uname");
		if (null != uname) {
	%>
	<div id="wrapper">
		<h2>Tervetuloa Admin sivulle</h2>
		<form action=index.html class="vastausformi">
			<input type="submit" id="Etusivu" value="Etusivu" />
		</form>
		<div>Alla olevasta painikkeesta pääset muokkaamaan, lisäämään ja
			poistamaan ehdokkaita</div>
		<br>
		<form action=LisaaKysymys.jsp class="vastausformi">
			<input type="submit" id="LisaaKysymys" value="Lisaa kysymys" />
		</form>

		<form action=MuokkaaKysymys.jsp class="vastausformi">
			<input type="submit" id="MuokkaaKysymys" value="Muokkaa kysymys" />
		</form>

		<form action=PoistaKysymys.jsp class="vastausformi">
			<input type="submit" id="PoistaKysymys" value="Poista kysymys" />
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
		<div id="themeslot">
			<!--  <a href="#" onclick="swapStyleSheet('style.css');">Vaalikone</a> <a
				href="#" onclick="swapStyleSheet('jalkapallostyle.css');">Jalkapallo</a>
				-->
			<label class="switch"> <input type="checkbox" id="myCheckbox"
				onchange="toggleCheck()" checked=""> <span class="slider"></span>
			</label>
		</div>
		<footer class="foot">
			<p>Robot3000</p>
		</footer>
	</div>
</body>
</html>
<%
	} else {
		response.sendRedirect("http://localhost:8080/index.html");
	}
%>


