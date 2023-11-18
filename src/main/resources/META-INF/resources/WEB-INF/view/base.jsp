<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
    .login-container button {
      float: right;
      padding: 6px 10px;
      margin-top: 8px;
      margin-right: 16px;
      background-color: #333;
      color: #fff;
      border: none;
      cursor: pointer;
    }
    .login-container button:hover {
      background-color: #000;
    }
</style>
</head>
<body>
	<header>
    <h1>Stationary Management</h1>
  </header>
  <nav>
    <ul>
      <li><a href="/">Home</a></li>
      <c:if test="${empty role}">
      <li><a href="/admin/login">Manage Items</a></li>
      <li><a href="/admin/login">Manage Stocks</a></li>
      <li><a href="/admin/login">Manage Orders</a>
      </c:if>
      <c:if test="${not empty role}">
      <li><a href="/item/items">Manage Items</a></li>
      <li><a href="/stock/stocks">Manage Stocks</a></li>
      <li><a href="/order/orders">Manage Orders</a></li>
      </c:if>
    </ul>
    <div class="login-container">
					  		<c:if test="${empty role}">
						        <li class="nav-item">
						          <a class="nav-link" href="/admin/login">Admin Login</a>
						        </li>
					        </c:if>
					        <c:if test="${not empty role}">
						        <li class="nav-item">
						          <a class="nav-link" href="/logout">Logout</a>
						        </li>
					        </c:if>
    </div>
  </nav>
</body>
</html>