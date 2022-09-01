<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>Admin - All Category</title>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>
<div align="center">
	<h2>Categories Magngement</h2>
	<h3><a href="/Computers/admin/create_category">Create new Category</a></h3>
</div>
<c:if test="${message != null}">
<div align="center">
	<h4><i>${message}</i></h4>
</div>
</c:if>
<div align="center">
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Action</th>
		</tr>
		<c:forEach var="category" items="${categories}" varStatus="status">
		<tr>
			<td>${category.name}</td>
			<td>
				<a href="/Computers/admin/edit_category?id=${category.id}">Edit</a> &nbsp;
				<a href="/Computers/admin/delete_category?id=${category.id}">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
</html>