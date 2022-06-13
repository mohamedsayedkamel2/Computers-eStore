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
	<h2>Products Management</h2>
	<h3><a href="/Computers4Sale/admin/create_product">Create new Product</a></h3>
</div>
<c:if test="${message != null}">
<div align="center">
	<h4><i>${message}</i></h4>
</div>
</c:if>
<div align="center">
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Category</th>
			<th>Description</th>
			<th>Image</th>
			<th>Price</th>
			<th>Avg. Rating</th>
			<th>Action</th>			
		</tr>
		<c:forEach var="product" items="${products}" varStatus="status">
		<tr>
			<td>${product.id}</td>
			<td>${product.name}</td>
			<td>${product.productCategory}</td>
			<td>${product.description}</td>
			<td><img src="${product.imgUrl}"/></td>
			<td>${product.price}</td>			
			<td>
				<a href="/Computers4Sale/admin/edit_product?id=${product.id}">Edit</a> &nbsp;
				<a href="/Computers4Sale/admin/delete_product?id=${product.id}">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
</html>