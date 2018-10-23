<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My cart</title>
</head>
<body>
    <c:forEach var="temp" items="${cart.productList}">
    <c:url var="productLink" value="/product">
        <c:param name="id" value="${temp.id}"/>
    </c:url>
    <tr>
        <td><a href=${productLink}>${temp.name}</a> </td>
        <td> ${temp.cost} </td> <td>
    </tr>
        <br>
    </c:forEach>
    <a href="/buyCart">Buy</a>
    <br>
    <a href="/">Back</a>
</body>
</html>
