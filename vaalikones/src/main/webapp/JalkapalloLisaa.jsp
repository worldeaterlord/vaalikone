<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lis�� puheenjohtajaehdokas tietokantaan</title>
<link id="theme" href="style.css" rel="stylesheet" type="text/css">
<script src="skript.js"></script>
</head>
<body>

	<form action="EmLuokka" method="POST">

		PJ Ehdokas <br> Etunimi <input class="kentta" type="text"name="etunimi" /> 
		Sukunimi <input class="kentta" type="text"name="sukunimi" /> 
		Ik� <input class="kentta" type="text" name="ika" />
		Pelipaikka <input class="kentta" type="text" name="pelipaikka" /> <br><br>
		<input type="submit" value='Lis�� PJ ehdokas' />
	</form>
</body>
</html>