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
	<h1>Stationary Items Available</h1>
	<a href="<%=request.getContextPath()%>/item/addItem"><h2>Add Items</h2></a> <br>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${items != null}">
			<h2>LIST OF ITEMS</h2>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Manufacturer</th>
						<th>Price</th>
						<th colspan = "2">Options</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="t" items="${items}">
						<tr>
							<td>${t.itemid}</td>
							<td>${t.itemname}</td>
							<td>${t.manufacturer}</td>
							<td>${t.price}</td>
							<td><a
								href="<%=request.getContextPath()%>/item/update/item/${t.itemid}">Update</a>
								&nbsp; <a
								href="<%=request.getContextPath()%>/item/delete/item/${t.itemid}"
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