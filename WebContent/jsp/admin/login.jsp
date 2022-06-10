<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>Admin - Login Page</title>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>

<c:if test="${message != null}">
<div align="center">
	<h4>${message}</h4>
</div>
</c:if>
<form method="post" action="/Computers4Sale/admin/login">
	<input type="email" name="email" required/>
	<input type="password" name="password" required/>
	<button type="submit">Submit</button>
	<input type="button" value="Cancel" onclick="history.go(-1);"/>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
<script type="text/javascript" src="/Computers4Sale/WebContent/js/customer-form.js"></script>
</form>
</body>
</html>