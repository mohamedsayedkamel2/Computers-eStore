<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>Computer4Sale</title>
<style>
.container {
  padding: 2rem 0rem;
}

h4 {
  margin: 2rem 0rem 1rem;
}

.table-image {
  td, th {
    vertical-align: middle;
  }
}
</style>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>
 <div class="alert alert-primary" role="alert" align="center">
  Choose the category of the product you want to buy
</div>
<div class="container">
  <div class="row">
    <div class="col-12">
		<table class="table table-image">
		  <thead>
		    <tr>
		      <th scope="col">no.</th>
		      <th scope="col"></th>
		      <th scope="col">Title</th>
		      <th scope="col">Price Range</th>
		      <th scope="col">Buy Page</th>
		      <th scope="col"></th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <th scope="row">1</th>
		      <td class="w-25">
			      <img src="https://m.media-amazon.com/images/I/71EyddkUnwL._AC_SY450_.jpg" class="img-fluid img-thumbnail" alt="Sheep">
		      </td>
		      <td>Ram (Computer Memory)</td>
		      <td>50$ - 300$</td>
		      <td><a href="./ram">Buy</a></td>
		      <td></td>
		    </tr>
		    <tr>
		      <th scope="row">2</th>
		      <td class="w-25">
			      <img src="https://media.istockphoto.com/photos/new-modern-black-pc-tower-with-copyspace-isolated-on-white-picture-id155154505?k=20&m=155154505&s=612x612&w=0&h=GtxLfIs93IsGls8k_X8h2P8c5oOYH836kLV6j-h7yrU=" class="img-fluid img-thumbnail" alt="Sheep">
		      </td>
		      <td>Computer Case</td>
		      <td>100$ - 500$</td>
		      <td><a href="./case">Buy</a></td>
		      <td></td>
		    </tr>
		    <tr>
		      <th scope="row">3</th>
		      <td class="w-25">
			      <img src="https://5.imimg.com/data5/WZ/MA/ZQ/SELLER-19884238/computer-hard-disk-500x500.jpg" class="img-fluid img-thumbnail" alt="Sheep">
		      </td>
		      <td>Computer Storage</td>
		      <td>50$ - 200$</td>
		      <td><a href="./hdd">Buy</a></td>
		      <td></td>
		    </tr>
		    <tr>
		      <th scope="row">4</th>
		      <td class="w-25">
			      <img src="https://www.ubuy.com.eg/productimg/?image=aHR0cHM6Ly9tLm1lZGlhLWFtYXpvbi5jb20vaW1hZ2VzL0kvODFVbDd2dTZaREwuX0FDX1NMMTUwMF8uanBn.jpg" class="img-fluid img-thumbnail" alt="Sheep">
		      </td>
		      <td>Motherboard</td>
		      <td>100$ - 1000$</td>
		      <td><a href="./motherboard">Buy</a></td>
		      <td></td>
		    </tr>
		  </tbody>
		</table>   
    </div>
  </div>
</div>
</body>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
</html>