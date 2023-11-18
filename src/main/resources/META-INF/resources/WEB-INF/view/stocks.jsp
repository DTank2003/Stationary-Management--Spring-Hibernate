<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Stationary Management</title>
<%@include file='base.jsp'%>
<style>
table {
      border-collapse: collapse;
      width: 100%;
      border: 1px solid #ddd;
      font-size: 14px;
      max-width: 1000px;
      overflow-y: scroll;
    }
    th, td {
      text-align: left;
      padding: 8px;
    }
    th {
      background-color: #4CAF50;
      color: white;
    }
    tr:nth-child(even) {
      background-color: #f2f2f2;
    }
</style>
</head>
<body>
	<h2>Stationary Stocks</h2>
	<a href="<%=request.getContextPath()%>/stock/addStock">Add Stock</a>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${stocks != null}">
			<h3>List of Stocks</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>ID</th>
						<th>ItemID</th>
						<th>ItemName</th>
						<th>Quantity</th>
						<th colspan = "2">Options</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="t" items="${stocks}">
						<tr>
							<td>${t.stockid}</td>
							<td>${t.itemid.itemid}</td>
							<td>${t.itemid.itemname}</td>
							<td>${t.quantityavailable}</td>
							<td><a
								href="<%=request.getContextPath()%>/stock/update/stock/${t.stockid}">Update</a>
								&nbsp; <a
								href="<%=request.getContextPath()%>/stock/delete/stock/${t.stockid}"
								onclick="return confirm('Do you really want to delete?')">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
        No User found in the DB!
        </c:otherwise>
	</c:choose>
</body>
</html>