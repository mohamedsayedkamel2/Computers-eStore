<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>Computer4Sale</title>
</head>
<body>
Welcome <c:out value="${sessionScope.user_email}"/>
<a href="/Computers4Sale/admin/logout">Logout</a>
<jsp:directive.include file="/jsp/common/header.jsp"/>
</body>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
</html>