<!DOCTYPE html>
<html>
  <head>
    <title>Order Placed Successfully</title>
    <style>
      body {
        background-color: #f2f2f2;
        font-family: Arial, sans-serif;
        text-align: center;
      }
      h1 {
        color: #008000;
      }
      .container {
        margin-top: 50px;
        margin-bottom: 50px;
      }
      .lead {
        font-size: 24px;
        font-weight: bold;
      }
      a {
        color: #008000;
        text-decoration: none;
      }
      a:hover {
        text-decoration: underline;
      }
      .text-success {
        color: #008000;
        font-weight: bold;
      }
      .text-muted {
        color: #999999;
        text-decoration: line-through;
      }
    </style>
    <%@include file='base.jsp'%>
  </head>
  <body>
    <div class="container">
      <h1>Thank you.</h1>
      <p class="lead">Your order has been placed successfully.</p>
      <p>Your order number is <a href="#">4598263104</a>. We will immediately process your order and it will be delivered soon.</p>
      <hr>
    </div>
  </body>
</html>