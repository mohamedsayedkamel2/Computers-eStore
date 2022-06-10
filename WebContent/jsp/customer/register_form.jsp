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
<form method="post" action="register">
	<input name="name" type="text" required/>
	<input name="email" type="email" required />
	<input name="password" type="password" required />
	<input name="country" />
	<input name="city" />
	<input type="submit" value="Register" />
<jsp:directive.include file="/jsp/common/footer.jsp"/>
</form>
</body>
</html>