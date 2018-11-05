<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <title>WebShop - Accounts</title>
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
    <h2>Accounts</h2>

    <hr>

    <p>
    <table class="table table-dark table-striped">
        <tr>
            <th>Username</th>
            <th>Password</th>
            <th>Enabled</th>
            <th>Roles</th>
            <th>Action</th>
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
                <td> ${temp.enabled} </td>
                <td>
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
</div>
</body>

</html>









