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
    <title>Login to JTA-Bank</title>
</head>
<body>
<h1>Welcome Back</h1>




<% if (request.getAttribute("error") != null) { %>
<p style="color: red;"> <%= request.getAttribute("error")%></p>
<% } %>


<form action="login" method="post">

    <table>
        <tr>
            <th>Email</th>
            <td>
                <input type="email" id="email" name="email" required>

            </td>
        </tr>

        <tr>
            <th>Password</th>
            <td>
                <input type="password" id="password" name="password" required>

            </td>
        </tr>
        <tr>
            <td></td>

            <td>
                <input type="submit" value="Login">

            </td>
        </tr>
    </table>

<%--    <label for="email"> Please Enter Your Email Address:</label>--%>
<%--    <input type="email" id="email" name="email" required>--%>
<%--    <br>--%>
<%--    <label for="password">Please Enter Your Password:</label>--%>
<%--    <input type="password" id="password" name="password" required>--%>
<%--    <br>--%>
<%--    <input type="submit" value="Login">--%>

</form>

<p>Don't have an account? <a href="register.jsp">Register here</a> </p>

</body>
</html>
