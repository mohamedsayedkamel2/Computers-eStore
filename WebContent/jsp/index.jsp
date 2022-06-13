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
<jsp:directive.include file="/jsp/common/header.jsp"/>
<div align="center">
<div>
 <div class="alert alert-primary" role="alert">
  Choose the category of the product you want to buy
</div>
    <a href="./ram">
 <img src="https://m.media-amazon.com/images/I/71EyddkUnwL._AC_SY450_.jpg" class="img-fluid mx-auto w-25 p-3" title="Ram" /></a> &nbsp;
    <a href="./case" >
<img src="https://media.istockphoto.com/photos/new-modern-black-pc-tower-with-copyspace-isolated-on-white-picture-id155154505?k=20&m=155154505&s=612x612&w=0&h=GtxLfIs93IsGls8k_X8h2P8c5oOYH836kLV6j-h7yrU=" class="img-fluid mx-auto w-25 p-3" title="Case" /></a> &nbsp;
    <a href="./hdd">
<img src="https://5.imimg.com/data5/WZ/MA/ZQ/SELLER-19884238/computer-hard-disk-500x500.jpg" class="img-fluid mx-auto w-25 p-3" title="Hard disk drive" /></a>&nbsp;
    <a href="./motherboard" >
<img src="https://www.ubuy.com.eg/productimg/?image=aHR0cHM6Ly9tLm1lZGlhLWFtYXpvbi5jb20vaW1hZ2VzL0kvODFVbDd2dTZaREwuX0FDX1NMMTUwMF8uanBn.jpg" class="img-fluid mx-auto w-25 p-3" title="Motherboard" /></a>
</div>
</div>
</body>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
</html>