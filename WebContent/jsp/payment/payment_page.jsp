<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>Review Payment Page</title>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>
<div align="center">
	${product.name} Payment Page
</div>
     <table align="center">
        <tr>
            <td><b>Product Name:</b></td>
            <td>${product.name}</td>
        </tr>     
        <tr>
            <td><b>Product Price: </b></td>
            <td>${product.price}</td>
        </tr>
     </table>
     <div align="center">
     <form action="/Computers4Sale/buy_product" method="post">
        <input type="hidden" name="id" value="${product.id}"/>
        <input type="submit" value="Pay"/>
        <input type="button" value="Return to previous page" onclick="history.go(-1);"/>
        </form>
     </div>   
<jsp:directive.include file="/jsp/common/footer.jsp"/>
</body>
</html>