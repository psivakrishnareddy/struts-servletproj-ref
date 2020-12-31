<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="language.do" method="post" >
   <input type="hidden" name="formid" value="lang">
   <select name="language">
   <option value="ta"> Tamil</option>
     <option value="te">Telugu</option> 
     <option value="hi"> hindi</option>    
     
   </select>
   <input type="submit" value="Select language">
</form>
</body>
</html>