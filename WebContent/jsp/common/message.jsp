<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>Computer4Sale</title>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>
	<div align="center">
		<h3>${message}</h3>
		<input type="button" value="Return to previous page" onclick="history.go(-1);"/>
	</div>
<script type="text/javascript" src="/Computers4Sale/WebContent/js/customer-form.js"></script>	
</body>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
</html>