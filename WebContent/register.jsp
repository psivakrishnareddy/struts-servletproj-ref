<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Register page...</h1>
	<h2>Customer Registration.....</h2>
		<form method="post" action="register.do">
	<input type="hidden" name="formid" value="register">
	
		UserName:<input type="text" name="uname"><br>
		PassWord:<input type="password" name="upass"><br>
		city: <input type="text" name="ucity"><br>
		<input type="submit" value="Signup">
	
	</form>
</body>
</html>