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
</head>
<body>
    <form:form action="process-product" modelAttribute="product">
        Name:<form:input path="name"/><br>
        Description:<form:input path="description"/><br>
        Cost:<form:input path="cost"/><br>
        <input type="submit"/>
    </form:form>
    <a href="/systems">Back</a>
</body>
</html>
