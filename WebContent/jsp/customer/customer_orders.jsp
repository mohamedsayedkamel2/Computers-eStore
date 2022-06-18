<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>${loggedCustomer.name}'s Orders</title>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>
<c:if test="${message != null}">
<div align="center">
	<h4><i>${message}</i></h4>
</div>
</c:if>
<c:if test="${orders == null}">
<div align="center">
You don't have any orders
</div>
</c:if>
<c:if test="${orders != null}">
<div align="center">
All Orders
</div>
<div align="center">
	<table border="1">
		<tr>
			<th>Product</th>
			<th>Price</th>
			<th>Purchase Date</th>				
		</tr>
		<c:forEach var="order" items="${orders}" varStatus="status">
		<tr>
			<td>${order.product.name}</td>
			<td>${order.subTotal}</td>
			<td>${order.orderDate}</td>
		</tr>
		</c:forEach>
	</table>
</div>
</c:if>
</body>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
</html>