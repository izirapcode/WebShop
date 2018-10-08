<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new account</title>
</head>
<body>
    <h1>Add new account</h1>
    <form:form action="processForm" modelAttribute="account">
        Username : <form:input path="username"/><br>
        Password : <form:input path="password"/><br>
        Employee <form:checkbox path="auhorities" value="ROLE_EMPLOYEE"/><br>
        Manager <form:checkbox path="auhorities" value="ROLE_MANAGER"/><br>
        Admin <form:checkbox path="auhorities" value="ROLE_ADMIN"/>
        <input type="submit" value="Submit">
    </form:form>
    <a href="/systems">Back</a>

</body>
</html>
