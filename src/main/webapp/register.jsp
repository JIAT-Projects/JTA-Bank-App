<%--
  Created by IntelliJ IDEA.
  User: lakkhanasudhamkalutara
  Date: 2026-08-23
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register to JTA-Bank</title>
</head>
<body>

<h1>Create New Account</h1>



<% if (request.getAttribute("error") != null) { %>
<p style="color: red;"> <%= request.getAttribute("error")%></p>
<% } %>


<form action="register" method="post">
    <label for="username">Please Enter Your Name:</label>
    <input type="text" id="name" name="name" required> <br>
    <label for="email"> Please Enter Your Email Address:</label>
    <input type="email" id="email" name="email" required>
    <br>
    <label for="password">Please Enter Your Password:</label>
    <input type="password" id="password" name="password" required>
    <br>
    <input type="submit" value="Register">

</form>

<p>Already have an account? <a href="login.jsp">Go to the login</a> </p>

</body>
</html>