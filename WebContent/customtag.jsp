<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/classes/codatags.tld" prefix="coda" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- 	<%
		int n=Integer.parseInt(request.getParameter("num"));
		if(n%2==0){
			out.println("even number.....");
		}
		else{
			out.println("odd number......");
		}	
	%> --%>
	<coda:checkNumber num="<%=request.getParameter(\"num\") %>"/>
</body>
</html>





