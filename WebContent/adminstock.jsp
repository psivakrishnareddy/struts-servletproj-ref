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
List<ItemDTO> items = is.getAll();

%>
<body>
<a href="adminpage.jsp"><button>< Go Back</button></a>
<hr>
<br>
<h1> available Stocks</h1>
<table id="table-1" border="1">
	<thead>
		<tr>
			<th>Item No</th>
			<th>Item</th>
			<th>unit</th>
			<th>Price</th>
			<th>Shopid</th>
			<th>Delete?</th>
		</tr>
	</thead>
	
	<tbody>
	<%
	Iterator<ItemDTO> iter = items.iterator();
	while(iter.hasNext()){
		ItemDTO item = iter.next();
		 %>
		<tr>
			<td><%=item.getItemno() %></td>
			<td><%=item.getItemdesc() %></td>
			<td><%=item.getUnit() %></td>
			<td><%=item.getPrice() %></td>
			<td><%= item.getShopid() %></td>
			<td><form method="post" action="deleteitem.do">
			<input type="hidden" name="formid" value="deleteitem">
			<input type="hidden" name="itemno" value="<%= item.getItemno()%>">
			<input type="submit" value="X"></form></td>
		</tr>
		<%} %>
	</tbody>
</table>

</body>
</html>