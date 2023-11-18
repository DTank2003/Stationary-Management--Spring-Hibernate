<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Signup</title>
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
	<div class='w-50 mx-auto my-5'>
		<h2>Admin Sign up Page</h2>
		<form:form action="/admin/signup" modelAttribute="admin" method="post">
			<div class="mb-3">
				<label for="email" class="form-label">Email</label> 
				<form:input path="email" type="email" cssClass="form-control" id='email' required="true"/>			
			</div>
			<div class="mb-3">
				<label for="name" class="form-label">Name</label> 
				<form:input path="username" type='text' cssClass="form-control" id='name' required="true" />			
			</div>
			<div class="mb-3">
				<label for="gender" class="form-label">Gender</label> 
				<form:select path="gender" id='gender' cssClass="form-control" required="true">  
	        		<form:option value="Male" label="Male"/>  
	        		<form:option value="Female" label="Female"/>  
	        	</form:select> 	 	
			</div>
			<div class="mb-3">
				<label for="pass" class="form-label">Password</label> 
				<form:input path="password" type='password' cssClass="form-control" id='pass' required="true" />			
			</div>
			<button class='w-100 btn btn-dark' type="submit">Submit</button>
		</form:form>
	</div>

</body>
</html>