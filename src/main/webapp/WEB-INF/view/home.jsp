<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
	<title>Home Page</title>
</head>

<body>
	<h2>Web Shop</h2>
	<hr>

	
	<hr>
	<h1>${cartNumber}</h1>
	<!-- display user name and role -->
	
	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	
	<hr>
	<security:authorize access="hasRole('MANAGER')">
	<!-- Add a link to point to /leaders ... this is for the managers -->
	
	<p>
		<a href="${pageContext.request.contextPath}/add-product">Add product</a>
	</p>
	</security:authorize>
	<!-- Add a link to point to /systems ... this is for the admins -->
	
	<security:authorize access="hasRole('ADMIN')">
	
	<p>
		<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
		(Only for Admin peeps)
	</p><hr>


	</security:authorize>

	<%--List of products--%>
	<table>
		<tr>
			<th>Name</th>
			<th>Cost</th>
		</tr>

		<c:forEach var="temp" items="${products}">
			<c:url var="productLink" value="/product">
				<c:param name="id" value="${temp.id}"/>
			</c:url>
			<tr>
				<td><a href=${productLink}>${temp.name}</a> </td>
				<td> ${temp.cost} </td> <td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	
</body>

</html>









