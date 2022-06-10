<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>Admin - All Customers</title>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>
<div align="center">
	<h2>Customers Management</h2>
	<h3><a href="/Computers4Sale/admin/create_customer">Create new Customer</a></h3>
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
			<th>Email</th>
			<th>Country</th>
			<th>City</th>
			<th>Registration Date</th>
			<th>Action</th>			
		</tr>
		<c:forEach var="customer" items="${customers}" varStatus="status">
		<tr>
			<td>${customer.id}</td>
			<td>${customer.name}</td>
			<td>${customer.email}</td>
			<td>${customer.country}</td>
			<td>${customer.city}</td>			
			<td>${customer.registerationDate}</td>			
			<td>
				<a href="/Computers4Sale/admin/edit_customer?id=${customer.id}">Edit</a> &nbsp;
				<a href="/Computers4Sale/admin/delete_customer?id=${customer.id}">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
</html>