<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>Admin - Edit Category</title>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>
<form method="post" action="/Computers/admin/edit_category">
	<input type="hidden" name="id" value="${category.id}"/>
	<input name="name" type="text" value="${category.name}" required/>
	<button type="submit">Submit</button>
	<input type="button" value="Cancel" onclick="history.go(-1);"/>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
<script type="text/javascript" src="/Computers/WebContent/js/customer-form.js"></script>
</form>
</body>
</html>