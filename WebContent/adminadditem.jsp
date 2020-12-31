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
<form action="additem.do" method="post" >
<input type="hidden" name="formid" value="additem">
ITEM NO:<input type="number" name="itemno" ><br><br>
ITEM NAME: <input type="text" name="itemname"><br><br>
ITEM UNIT: <input type="text" name="itemunit"><br><br>
ITEM PRICE: <input type="text" name="itemprice"><br><br>

SHOPID : <select name="itemshopid">
   <option value="110"> Ration Shop</option>
     <option value="112">Snacks Shop</option> 
     <option value="212"> Stationay shop</option>    
     
   </select><br><br>
<input type="submit" value="Add Item"><br>
</form>
</body>
</html>