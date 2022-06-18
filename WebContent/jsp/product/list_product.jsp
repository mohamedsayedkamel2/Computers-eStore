<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>Product List</title>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>
<c:if test="${message != null}">
<div align="center">
	<h4><i>${message}</i></h4>
</div>
</c:if>
<div align="center">
${category} Products List
</div>
<div align="center">
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Image</th>
			<th>Price</th>
			<th></th>		
			<th></th>				
		</tr>
		<c:forEach var="result" items="${results}" varStatus="status">
		<tr>
			<td>${result.name}</td>
			<td>${result.description}</td>
			<td><img src="${result.imgUrl}"/></td>
			<td>${result.price}</td>			
			<td>
				<a href="/Computers4Sale/reviews_product?id=${result.id}">See Product reviews</a> &nbsp;
			</td>
			<td>
				<a href="/Computers4Sale/buy_product?id=${result.id}">Buy Product</a> &nbsp;
			</td>			
		</tr>
		</c:forEach>
	</table>
</div>
</body>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
</html>