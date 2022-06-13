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

	<form method="post" action="/Computers4Sale/admin/edit_review">
	<input type="hidden" name="id" value="${review.id}" />
	Review Headline: <input name="headline" type="text" value="${review.headLine}" required/>
	<button type="submit">Submit</button>
	<input type="button" value="Cancel" onclick="history.go(-1);"/>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
<script type="text/javascript" src="/Computers4Sale/WebContent/js/customer-form.js"></script>
</form>
</body>
</html>