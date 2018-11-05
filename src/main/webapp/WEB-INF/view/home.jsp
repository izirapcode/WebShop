<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
	<title>WebShop - Home</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Reference Bootstrap files -->
	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
<div class="container">
	<h6 class="col-sm-1 col-sm-offset-11">User: <security:authentication property="principal.username" /></h6>
	<h2>Web Shop</h2>
	<hr>

	<h4 class="text-success"> <a href="/cart"  >My cart</a> | <a href="/orders" >My orders</a> </h4>
	<hr>
	<!-- display user name and role -->

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
	</p><hr>


	</security:authorize>
	<%--List of products--%>
	<table class="table table-dark table-striped">
		<tr>
			<th>Name</th>
			<th>Cost</th>
		</tr>

		<c:forEach var="temp" items="${products}">
			<c:url var="productLink" value="/product">
				<c:param name="id" value="${temp.id}"/>
			</c:url>
			<tr>
				<td><a href=${productLink} class="text-info">${temp.name}</a> </td>
				<td> ${temp.cost} </td> <td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" class="btn" />
	
	</form:form>
</div>
</body>

</html>









