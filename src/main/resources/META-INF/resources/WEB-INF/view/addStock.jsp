<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<%@include file='base.jsp'%>
</head>
<body>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<h3>Add Stock</h3>
	<form method="POST" name="add_stock"
		action="<%=request.getContextPath()%>/stock/add/stock">
		<div class="form-group">
		Item id: <input name="itemid" type="text" /></div> 
		Quantity: <input name="quantityavailable" value="${quantityavailable}" type="text" />
		<br> <br>
		<input value="Add Stock" type="submit" />
	</form>
</body>
</html>