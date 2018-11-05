<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new account</title>

    <script>
        //if account is being updated turn off username edit
        function usernameEditable() {
            var username = document.getElementById('username');
            if (username.value) username.disabled=true;
        }
    </script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body onload="usernameEditable()">
    <h1>Add new account</h1>
    <form:form action="processForm" modelAttribute="account">
        Username : <form:input path="username"/><br>
        Password : <form:input path="password"/><br>
        <security:authorize access="hasRole('ADMIN')">
            Enabled <form:checkbox path="enabled"></form:checkbox><br>
            Employee <form:checkbox path="auhorities" value="ROLE_EMPLOYEE"/><br>
            Manager <form:checkbox path="auhorities" value="ROLE_MANAGER"/><br>
            Admin <form:checkbox path="auhorities" value="ROLE_ADMIN"/>
        </security:authorize>
        <input type="submit" value="Submit">
    </form:form>
    <a href="/systems">Back</a>

</body>
</html>
