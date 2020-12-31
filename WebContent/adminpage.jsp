<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<hr>
	<form action="logoud.do" method="post">
	<input type="hidden" name="formid" value="logout">
		<input type="submit" value="logout">
	</form>
<hr>
<h1>Welcome Admin</h1>
<hr>
<br>
<h3>Select your operations</h3>
<ul>
<li><a href="adminreports.jsp">Generate Reports</a></li>
<li><a href="adminstock.jsp">Get Stock Details</a></li>
<li><a href="adminadditem.jsp">Add Items</a></li>
</ul>
</body>
</html>