<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Stationary Management</title>
<%@include file='base.jsp'%>
</head>
<body>
	<h2>UPDATE STOCK DETAILS</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<form method="POST" name="update_stock"
		action="<%=request.getContextPath()%>/stock/update/stock">
		<input hidden="hidden" name="stockid" value="${stock.stockid}" type="number" />
		ItemID: <input name="itemid" value="${stock.itemid.itemid}" type="text" /> <br /> <br />
		Quantity: <input name="quantityavailable" value="${stock.quantityavailable}" type="text" />
		<br /> <br />
		 <input value="Update Stock"
			type="submit" />
	</form>
</body>
</html>