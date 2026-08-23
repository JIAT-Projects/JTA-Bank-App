<%--
  Created by IntelliJ IDEA.
  User: lakkhanasudhamkalutara
  Date: 2026-08-12
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1>Something went wrong! </h1>
<br>
<div><%= exception != null ? exception.getMessage() : "An unknown error occurred." %></div>
<br>

<button onclick="location.href='index.jsp'">Go to Home </button>

</body>
</html>
