<%--
  Created by IntelliJ IDEA.
  User: Michal Izydorczyk
  Date: 16.10.2018
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new product</title>
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
    <form:form action="process-product" modelAttribute="product">
        Name:<form:input path="name"/><br>
        Description:<form:input path="description"/><br>
        Cost:<form:input path="cost"/><br>
        <input type="submit"/>
    </form:form>
    <a href="/">Back</a>
</div>
</body>
</html>
