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
    <title>JTA-Bank | Dashboard</title>
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
    <h1>Welcome ${sessionScope.userName}</h1>

    <h2>Your Accounts: </h2>

    <% List<Account> accounts = (List<Account>) request.getAttribute("accounts");

    if (accounts == null || accounts.isEmpty()) { %>
               <p>You have no accounts. <a href="create-account">Create One</a></p>
    <% } else { %>
        <table border="1">
            <tr>
                <th>Account Number</th>
                <th>Account Type</th>
                <th>Balance</th>
                <th>Action</th>
            </tr>
            <% for (Account account : accounts) { %>
                <tr>
                    <td><%= account.getAccNo() %></td>
                    <td><%= account.getAccountType() %></td>
                    <td><%= account.getBalance() %></td>
                    <td><a href="history?accountNo=<%= account.getAccNo() %>">View Transaction History</a></td>
                </tr>
            <% } %>
        </table>
    <% } %>

</body>
</html>
