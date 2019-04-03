<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,vaalikone.Vaalikone,persist.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin sivu</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2>Tervetuloa Admin sivulle</h2>

<div>
Alla olevasta painikkeesta pääset muokkaamaan ja poistamaan ehdokkaita</div><br>
	<form action=MuokkaaEhdokas id="vastausformi">
  	<input type="submit" id="MuokkaaEhdokasta" value="Muokkaa ehdokas" />
  	</form>
  	
	<form action="PoistaEhdokas" id="vastausformi">
	<input type="submit" id="PoistaEhdokas" value="Poista ehdokas" />
	</form>
	
	<form action="LisaaEhdokas" id="vastausformi">
	<input type="submit" id="LisaaEhdokas" value="Lisää ehdokas" />
 	</form>
 	
</body>
</html>