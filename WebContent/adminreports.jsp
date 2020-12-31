<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="adminpage.jsp"><button>< Go Back</button></a>
<hr>
<br>
<h1>Click Here For generating Reports</h1>
<form action="shopping.do" method="post">
	<input type="hidden" name="formid" value="report">
	<input type="date" name="fromdate"> TO 
	<input type="date" name="todate">
	<input type="submit" value="Generate">
	</form>
</body>
</html>