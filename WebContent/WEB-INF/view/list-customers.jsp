<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>

	<div id="container">

		<div id="content">


			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="temp" items="${customers}">
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${temp.id }"></c:param>
					</c:url>

					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${temp.id }"></c:param>
					</c:url>

					<tr>
						<td>${temp.firstName}</td>
						<td>${temp.lastName}</td>
						<td>${temp.email}</td>
						<td><a href="${updateLink}">Update</a> 
						<a 
						onclick="if (!(confirm('Are u sure you want to delete?'))) return false"
						href="${deleteLink}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>

</body>
</html>