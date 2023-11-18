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
	<h3>Add Item</h3>
	<form method="POST" name="add_item"
		action="<%=request.getContextPath()%>/item/add/item">
		<div class="form-group">
		Name: <input name="name" value="${itemname}" type="text" /></div> 
		Manufacturer: <input name="manufacturer" value="${manufacturer}" type="text" />
		<br> <br>
		Price: <input name="price" value="${price}" type="number" />
		<br /> <br />
		<input value="Add Item" type="submit" />
	</form>
</body>
</html>