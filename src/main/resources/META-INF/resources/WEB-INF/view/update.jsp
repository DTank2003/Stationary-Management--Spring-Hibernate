<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Stationary Management</title>
<%@include file='base.jsp'%>
</head>
<body>
	<h2>UPDATE ITEM DETAILS</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<form method="POST" name="update_item"
		action="<%=request.getContextPath()%>/item/update/item">
		<input hidden="hidden" name="itemid" value="${item.itemid}" type="text" />
		Name: <input name="name" value="${item.itemname}" type="text" /> <br /> <br />
		Manufacturer: <input name="manufacturer" value="${item.manufacturer}" type="text" />
		<br /> <br />
		Price: <input name="price" value="${item.price}" type="number" /> <br /> <br />
		 <input value="Update Item"
			type="submit" />
	</form>
</body>
</html>