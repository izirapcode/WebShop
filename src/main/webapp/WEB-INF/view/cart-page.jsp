<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My cart</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
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
</div>
</body>
</html>
