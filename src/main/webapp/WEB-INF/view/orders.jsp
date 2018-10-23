<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
    <c:forEach var="orders" items="${user}">
        <h3>Order ${orders.id} : ${orders.date}</h3>
       <c:forEach var="product" items="${orders.products}">
            ${product.name}<br>
        </c:forEach>
    </c:forEach>
    <br> <a href="/">Back to home</a>
</body>
</html>
