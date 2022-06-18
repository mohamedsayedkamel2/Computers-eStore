<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>Admin - All Users</title>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>
<div align="center">
	<h2>Users Management</h2>
	<h3><a href="/Computers4Sale/admin/create_user">Create new User</a></h3>
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
			<th>Action</th>
		</tr>
		<c:forEach var="user" items="${users}" varStatus="status">
		<tr>
			<td>${user.id}</td>
			<td>${user.fullName}</td>
			<td>${user.email}</td>
			<td>
				<a href="/Computers4Sale/admin/edit_user?id=${user.id}">Edit</a> &nbsp;
				<a href="/Computers4Sale/admin/delete_user?id=${user.id}">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
</html>