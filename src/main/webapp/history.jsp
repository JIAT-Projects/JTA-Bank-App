<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
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
    <title>JTA-Bank | Transaction History</title>
</head>
<body>
<h1>History for ${requestScope.accountNo}</h1>




<table>
    <tr>
        <th>Date/Time</th>
        <th>Type</th>
        <th>Amount</th>
        <th>Related Account</th>
        <th>Balance After</th>
    </tr>

    <c:forEach var="transactions" items="${requestScope.transactions}">
        <tr>
            <td>${transactions.timestamp}</td>
            <td>${transactions.type}</td>
            <td>
                    <fmt:formatNumber value="${transactions.amount}" type="number" minFractionDigits="2" maxFractionDigits="2" groupingUsed="true" />
                   </td>
            <td>${transactions.relatedAccountNo eq null ? "-" : transactions.relatedAccountNo}</td>
            <td>
                <fmt:formatNumber value="${transactions.balanceAfter}" type="number" minFractionDigits="2" maxFractionDigits="2" groupingUsed="true" />

          </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
