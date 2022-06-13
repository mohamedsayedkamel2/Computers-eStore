<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>
<form method="post" action="/Computers4Sale/edit_profile">
	<input name="name" type="text" value="${loggedCustomer.name}" required/>
	<input name="password" type="password" value="${loggedCustomer.password}" required />
	<input name="country" value="${loggedCustomer.country}" />
	<input name="city" value="${loggedCustomer.city}" />
	<input type="submit" value="Update" />
<jsp:directive.include file="/jsp/common/footer.jsp"/>
</form>
</body>
</html>