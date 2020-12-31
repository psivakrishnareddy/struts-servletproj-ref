<%@page import="java.util.List"%>
<%@page import="bussinessmodel.ItemServiceImpl"%>
<%@page import="bussinessmodel.ItemService"%>
<%@page import="model.ItemDTO"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
ItemService is = new ItemServiceImpl();
List<ItemDTO> items = is.getItemsByShop(112);

%>
<body>
	<h1>Snacks Shop</h1>
	<form action="shopping.do" method="post">
	<input type="hidden" name="formid" value="shop">
	<input type="hidden" name="shopid" value="shop2">
	<table border="1">
	<%
	Iterator<ItemDTO> iter = items.iterator();
	while(iter.hasNext()){
		ItemDTO item = iter.next();
		 %>
		
		<tr>
		<td><%= item.getItemdesc()%></td>
		<td><input type="checkbox" name="<%= item.getItemno()%>" value="<%= item.getItemdesc()%>"></td>
		<td>Rs. <%=item.getPrice() %></td>
		<td><img src="radio.png"></td>
	</tr>
	<%}%>
	</table>
		<input type="submit" value="NextShop..">
	</form>
</body>
</html>