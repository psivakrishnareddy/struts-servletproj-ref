<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>

	<form  action="invoice.do" id="form-1" method="post">
	<h1>Proceed to Buy ?</h1>
	<input type="hidden" name="formid" value="billing">
	<input type="submit" value="Place order"> 
	</form>
</h2>
</body>
</html>