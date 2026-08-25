<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="lk.jiat.bcd.jta.bank.entity.Account" %><%--
  Created by IntelliJ IDEA.
  User: lakkhanasudhamkalutara
  Date: 2026-08-23
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JTA-Bank | Withdraw</title>
</head>
<body>

<naV>
    <a href="dashboard"> Dashboard</a>
    <a href="deposit"> Deposit</a>
    <a href="withdraw"> Withdraw</a>
    <a href="transfer"> Transfer</a>
    <a href="create-account"> New Account</a>
    <a href="logout"> Logout</a>
</naV>

<div>


    <h1>Deposit </h1>

        <% if (request.getAttribute("error") != null) { %>
    <p style="color: red;"> <%= request.getAttribute("error")%></p>
        <% } %>

    <form action="withdraw" method="post">
        <table>
            <tr>
                <th>Account Number:</th>
                <td><select name="accountNo" required>
                   <option value="" disabled selected>Select Account</option>
                    <c:forEach var="account" items="${requestScope.accounts}">
                        <option value="${account.accNo}">${account.accNo} - ${account.accountType}</option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td>Amount:</td>
                <td><input type="number" name="amount" step="0.01" min="0.01" required></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Withdraw"></td>

            </tr>
        </table>

    </form>


</body>
</html>
