<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,vaalikone.Vaalikone,persist.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lisaa ehdokas sivu</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%String uname =(String)session.getAttribute("uname");
if(null!=uname){%><h2>Lisää Ehdokas</h2>

<div>




<form action="LisaaHelper" method="POST">

Ehdokas ID<input type="text" name="id"/><br>
Sukunimi<input type="text" name="Sukunimi"/><br>
Etunimi<input type="text" name="Etunimi"/><br>
Puolue<input type="text" name="Puolue"/><br>
Kotipaikkakunta<input type="text" name="Kotipaikkakunta"/><br>
Ikä<input type="text" name="ikä"/><br>
Miksi eduskuntaan<input type="text" name="Miksieduskuntaan"/><br>
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
