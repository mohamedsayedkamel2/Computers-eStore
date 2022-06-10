<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>Admin - Create Product</title>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>
	<div align="center">
		<h2 class="pageheading">
		<c:if test="${product != null}">Edit Product</c:if>
		<c:if test="${product == null}">Create New Product</c:if>
		</h2>
	</div>
	<c:if test="${product != null}">
	<form method="post" action="/Computers4Sale/admin/edit_product">
	<input type="hidden" name="id" value="${product.id}" />
	</c:if>
	<c:if test="${product == null}">
	<form action="/Computers4Sale/admin/create_product" method="post">
	</c:if>
	<input name="name" type="text" required/>
	<c:if test="${product == null}">
	<input name="description" type="text" required/>
	<input name="price" type="text" required/>
	<select name="category">
	<c:forEach items="${categories}" var="category">
	<c:if test="${category.id eq product.productCategory.id}">
		<option value ="${category.id}" selected>
	</c:if>
	<c:if test="${category.id ne product.productCategory.id}">
		<option value ="${category.id}">
	</c:if>
		 ${category.name}
		</option>
	</c:forEach>
	</select>	
	<input name="img_url" type="text" required/>
	</c:if>
	<button type="submit">Submit</button>
	<input type="button" value="Cancel" onclick="history.go(-1);"/>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
<script type="text/javascript" src="/Computers4Sale/WebContent/js/customer-form.js"></script>
</form>
</body>
</html>