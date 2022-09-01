<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>Admin - Create Customer</title>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>
	<div align="center">
		<h2 class="pageheading">
		<c:if test="${customer != null}">Edit Customer</c:if>
		<c:if test="${customer == null}">Create New Customer</c:if>
		</h2>
	</div>
	<c:if test="${customer != null}">
	<form method="post" action="/Computers/admin/edit_customer">
	<input type="hidden" name="id" value="${customer.id}" />
	</c:if>
	<c:if test="${customer == null}">
	<form action="/Computers/admin/create_customer" method="post">
	</c:if>
	<input name="name" type="text" value="${customer.name}"/>
	<input name="email" type="email" value="${customer.email}"/>
	<input name="password" type="password" value="${customer.password}"/>
	<input name="country" type="text" value="${customer.country}"/>
	<input name="city" type="text" value="${customer.city}"/>
	<button type="submit">Submit</button>
	<input type="button" value="Cancel" onclick="history.go(-1);"/>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
<script type="text/javascript" src="/Computers/WebContent/js/customer-form.js"></script>
</form>
</body>
</html>