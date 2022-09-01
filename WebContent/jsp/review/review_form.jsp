<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>Submit a Review!</title>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>
<div align="center">
<h3>Becareful! Once you submit a review you can't change it</h3>
</div>
	<form method="post" action="/Computers/write_review">
	<input type="hidden" name="id" value="${product.id}"/>
	Review Headline: <input name="headline" type="text" required/>
	Comment: <input name="comment" type="text" required/>	
	<button type="submit">Submit</button>
	<input type="button" value="Cancel" onclick="history.go(-1);"/>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
<script type="text/javascript" src="/Computers/WebContent/js/customer-form.js"></script>
</form>
</body>
</html>