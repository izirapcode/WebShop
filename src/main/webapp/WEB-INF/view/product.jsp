<%--
  Created by IntelliJ IDEA.
  User: Michal Izydorczyk
  Date: 12.10.2018
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebShop - Product</title>
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
    <h1>${product.name}</h1><br>
<p>${product.description}</p><br>
<hr><br>
Cost : ${product.cost} $<br>
    <form action="/buyProduct">
        <input type="hidden" value="${product.id}" name="id">
        <input type="submit" value="Add to cart">
    </form>
<a href="/">Back</a>
</div>
</body>
</html>
