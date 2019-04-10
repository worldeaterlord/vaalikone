<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="vaalikone.MuokkaaKysymysHandler"%>
<%@page import="persist.Vastaukset"%>
<%@page import="java.util.List"%>
<%@page import="persist.Ehdokkaat"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>>Lisaa kysymys</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>


<%String uname =(String)session.getAttribute("uname");
if(null!=uname){%>
<h2>Lisää uusi kysymys</h2>
<div>
<%
try {

	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost/vaalikone";
	String username="root";
	String password="";
	String query = "SELECT * FROM kysymykset";
	Connection con = DriverManager.getConnection(url,username,password);
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(query);
	PrintWriter iiii = response.getWriter();
	iiii.print("<div id='wrapper'>");
	while (rs.next()) {
		%>
		<tr>
		<%iiii.print(rs.getInt("KYSYMYS_ID")+ "\n");%>
		</tr>
		<tr>
		<th><%iiii.print(rs.getString("KYSYMYS")+ "\n" + "<br>");%></th>
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

<form action="LisaaKysymysHandler" method="POST">

<!--Kysymys ID<input type="text" name="kysymys_id"/><br>-->
Kysymys<input type="text" name="kysymys"/><br>

<input type="submit" value='lisaaKysymys'/>

</form>
</div>


</div>
</body>
</html>
<% }else{
		response.sendRedirect("http://localhost:8080/index.html");
	} %>