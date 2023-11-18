<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Stationary Management</title>
<%@include file='base.jsp'%>
</head>
<body>
	<h2>UPDATE ORDER DETAILS</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<form method="POST" name="update_order"
		action="<%=request.getContextPath()%>/order/update/order">
		<input hidden="hidden" name="orderid" value="${order.orderid}" type="number" />
		Status: <input name="status" value="${order.status}" type="text" />
		<br /> <br />
		 <input value="Update Order"
			type="submit" />
	</form>
</body>
</html>