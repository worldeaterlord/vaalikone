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
<h2>Lisää Ehdokas</h2>

<div>

<%String name = request.getParameter("name"); %>
<% %>


<form action="LisaaEhdokasHandler" method="post">

Ehdokas ID<input type="text" name="EHDOKAS_ID"/><br>
Sukunimi<input type="text" name="SUKUNIMI"/><br>
Etunimi<input type="text" name="ETUNIMI"/><br>
Puolue<input type="text" name="PUOLUE"/><br>
Kotipaikkakunta<input type="text" name="KOTIPAIKKAKUNTA"/><br>
Ikä<input type="text" name="IKA"/><br>
Miksi eduskuntaan<input type="text" name="MIKSI_EDUSKUNTAAN"/><br>
Mitä asioita haluat edistää<input type="text" name="MITÄ_ASIOITA_HALUAT_EDISTAA"/><br>
Ammatti<input type="text" name="AMMATTI"/><br>
<input type="submit"/>

</form>
</div>
</body>
</html>