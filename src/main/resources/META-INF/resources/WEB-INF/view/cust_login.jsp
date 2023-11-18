<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"> 
<style>
body {
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
</style> 
</head>
<body>
	<header>
    <h1>Stationary Management</h1>
  </header>
	<div class=' my-5 w-50 mx-auto'>
		<c:if test="${not empty success}">
        	<div class="alert alert-success alert-dismissible fade show" role="alert">
				${success}
				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
    	</c:if>
    	<c:if test="${not empty error}">
        	<div class="alert alert-danger alert-dismissible fade show" role="alert">
				${error}
				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
    	</c:if>
		<h2>Admin Login Page</h2>
		<form method="POST" action="<%=request.getContextPath()%>/admin/login">
			<div class="mb-3">
				<label for="email" class="form-label">Email address</label> 
				<input type="email" class="form-control" id="email" name='email' >
				
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label> 
				<input type="password" name='password' class="form-control" id="password">
			</div>
			<div>
				<a href='/admin/signup'>New user? Sign up here!</a>
			</div>
			<button type="submit" class="w-100 btn btn-dark">Submit</button>
		</form>
	</div>

</body>
</html>