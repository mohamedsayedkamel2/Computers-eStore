<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>Computers4Sale - Login</title>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>
<c:if test="${message != null}">
<div align="center">
	<h4>${message}</h4>
</div>
</c:if>
<form action="login" method="post">
 Email: <input type="email" name="email"/>
 Password: <input type="password" name="password"/>
 <input type="submit" value="Login" />
</form>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
</body>
</html>