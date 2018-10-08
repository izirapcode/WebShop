<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <title>luv2code SYSTEMS Home Page</title>
</head>

<body>

<h2>luv2code SYSTEMS Home Page</h2>

<hr>

<p>
<table>
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Enabled</th>
        <th>Roles</th>
    </tr>
    <c:forEach var="temp" items="${users}">
        <c:url var="updateLink" value="/update">
            <c:param name="id" value="${temp.username}"/>
        </c:url>

        <!-- construct an "delete" link with customer id -->
        <c:url var="deleteLink" value="/delete">
            <c:param name="id" value="${temp.username}"/>
        </c:url>
        <tr>
            <td> ${temp.username} </td>
            <td> ${temp.password} </td>
            <td> ${temp.enabled} </td> <td>
            <c:forEach var="authority" items="${temp.authorities}">
           ${authority.authority},
            </c:forEach>
            </td>
            <td>
                <!-- display the update link -->
                <a href="${updateLink}">Update</a>
                |
                <a href="${deleteLink}"
                   onclick="if (!(confirm('Are you sure?'))) return false">Delete</a>
            </td>

        </tr>
    </c:forEach>
</table>
<a href="/addNewAccount">Add new account</a>
</p>

<hr>

<a href="${pageContext.request.contextPath}/">Back to Home Page</a>

</body>

</html>









