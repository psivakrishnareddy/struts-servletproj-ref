<%@page import="java.util.List"%>
<%@page import="java.util.ListIterator"%>
<%@page import="control.ActionErrors"%>
<%@page import="control.ActionError"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="blue">
<center>
<%
ResourceBundle rb = (ResourceBundle)session.getAttribute("rb");
ActionErrors errors = (ActionErrors) request.getAttribute("errors");
if(errors!=null){
	/* Iterator<ActionError> iter = errors.getErrors().iterator();
	while(iter.hasNext()){
		out.println(iter.next().getMsg());
	} */
	for(int i = 0; i<errors.getErrors().size();i++){
		out.println(errors.getErrors().get(i).getMsg());	
		}
}
%>
	<form method="post" action="login.do">
	<input type="hidden" name="formid" value="login">
	
		<%=rb.getString("username") %><input type="text" name="uname">
		<%=rb.getString("password") %><input type="password" name="upass">
		
		<input type="submit" value="login..">
	    <a href="register.jsp"><button>Register</button></a>
	</form>
</center>
</body>
</html>