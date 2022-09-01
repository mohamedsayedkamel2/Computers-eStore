<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>Admin - All Products</title>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>
<div align="center">
	<h2>Reviews Management</h2>
</div>
<c:if test="${message != null}">
<div align="center">
	<h4 style="color:red;"><i>${message}</i></h4>
</div>
</c:if>
<div align="center">
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Head Line</th>
			<th>Rating</th>
			<th>Customer</th>
			<th>Product</th>			
			<th>Action</th>			
		</tr>
		<c:forEach var="review" items="${reviews}" varStatus="status">
		<tr>
			<td>${review.id}</td>
			<td>${review.headLine}</td>
			<td>${review.rating}</td>
			<td>${review.customer.name}</td>
			<td>${review.product.name}</td>									
			<td>
				<a href="/Computers/admin/edit_review?id=${review.id}">Edit</a> &nbsp;
				<a href="/Computers/admin/delete_review?id=${review.id}">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
</html>