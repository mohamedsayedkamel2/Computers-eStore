<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>${loggedCustomer.name}'s profile</title>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>
     <table align="center">
        <tr>
            <td><b>Name:</b></td>
            <td>${loggedCustomer.name}</td>
        </tr>     
        <tr>
            <td><b>E-mail: </b></td>
            <td>${loggedCustomer.email}</td>
        </tr>
        <tr>
            <td><b>Country:</b></td>
            <td>${loggedCustomer.country}</td>
        </tr>        
        <tr>
            <td><b>City:</b></td>
            <td>${loggedCustomer.city}</td>
        </tr>
		<c:if test="${loggedCustomer.customerOrders != null}">
			<tr>
			<c:forEach var="order" items="${loggedCustomer.customerOrders}" varStatus="status">
				<td><b>Orders</b></td>
				<td${order.product.name}></td>
			</c:forEach>
			</tr>
		</c:if>		
        <tr><td>&nbsp;</td></tr>
        <tr>
            <td colspan="2" align="center"><b><a href="/Computers4Sale/edit_profile">Edit My Profile</a></b></td>
        </tr>
     </table>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
</body>
</html>