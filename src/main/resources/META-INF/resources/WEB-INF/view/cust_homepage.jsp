<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Stationary Management</title>
  <style>
    body {
      background-image: linear-gradient(-90deg, #91EAE4, #7F7FD5);
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }
    header {
      background-color: #333;
      color: #fff;
      padding: 10px;
      text-align: center;
    }
    nav {
      background-color: #f2f2f2;
      display: flex;
      justify-content: space-between;
      padding: 10px;
    }
    nav ul {
      list-style-type: none;
      margin: 0;
      padding: 0;
    }
    nav li {
      display: inline;
      margin-right: 20px;
    }
    nav a {
      color: #333;
      text-decoration: none;
    }
    nav a:hover {
      color: #000;
    }
    .login-container {
      float: right;
    }
    .login-container input[type=text], .login-container input[type=password] {
      padding: 6px;
      margin-top: 8px;
      margin-right: 16px;
      border: none;
      width: 130px;
    }
    .login-container input[type=submit] {
      float: right;
      padding: 6px 10px;
      margin-top: 8px;
      margin-right: 16px;
      background-color: #333;
      color: #fff;
      border: none;
      cursor: pointer;
    }
    .login-container input[type=submit]:hover {
      background-color: #000;
    }
    .product-container {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-gap: 20px;
}

.product-card {
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 10px;
  text-align: center;
}

.product-card img {
  max-width: 100%;
}

.product-card h2 {
  font-size: 1.2rem;
  margin: 10px 0;
}

.product-card p {
  margin: 10px 0;
}

.product-card .price {
  font-weight: bold;
}

.product-card input[type=submit] {
  background-color: #ff0066;
  border: none;
  border-radius: 5px;
  color: #fff;
  cursor: pointer;
  font-size: 1rem;
  margin-top: 10px;
  padding: 10px;
  width: 100%;
}

.product-card button:hover {
  background-color: #0069d9;
}
  </style>
  <%@include file='base.jsp'%>
</head>
<body>
  <main>
    <h2>Welcome to our Stationary Management website!</h2>
    <p>Here you can find a wide range of products at affordable prices.</p>
  </main>
  <div class="product-container">
  <c:if test="${not empty success}">
    </c:if>
    <c:choose>
    	<c:when test="${items != null}">
    	<c:forEach var="a" items="${items}">
				  <div class="product-card">
				    <h2>${a.itemname}</h2>
				    <p>Manufacturer: ${a.manufacturer}</p>
				    <p class="price">Rs. ${a.price}</p>
				    
				    
			        <form method="POST" name="add_order"
						action="<%=request.getContextPath()%>/order/add/order">
						<input hidden="hidden" name="itemid" value="${a.itemid}" type="text" />
						<input hidden="hidden" name="status" value="PLACED" type="text" />
						<br /> <br />
						<input value="ORDER" type = "submit"/>
					</form>			
				    
				    
				  </div>
    	</c:forEach>
    	<c:if test="${empty items}">No Item Pending</c:if>
        </c:when>
    </c:choose>
</div>
  <footer>
    <p>&copy; 2023 Stationary Shopping Website. All rights reserved.</p>
  </footer>
</body>
</html>