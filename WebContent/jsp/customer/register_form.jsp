<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>Registration Page</title>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>

<c:if test="${message != null}">
<div align="center">
	<h4>${message}</h4>
</div>
</c:if>
<form style="max-width: 700px; margin: 0 auto" method="post" action="/Computers4Sale/register" align="center">
<div class="border border-secondary rounded p-3" align="center">
	<div class="form-group-row">
<label class="col-sm-4 col-form-Label">Name</label>
	<div class="col-sm-8">	
	<input type="text" name="name" required/>
	</div></div>
	<div class="form-group-row">
<label class="col-sm-4 col-form-Label">Email</label>
	<div class="col-sm-8">	
	<input type="email" name="email" required/>
	</div></div>	
	<div class="form-group-row">
<label class="col-sm-4 col-form-Label">Password</label>
	<div class="col-sm-8">	
	<input type="password" name="password" required/>
	</div></div>
	<div class="form-group-row">
	<label class="col-sm-4 col-form-Label">Country</label>
	<div class="col-sm-8">	
	<input type="text" name="country" required/>
	</div></div>
	<div class="form-group-row">
<label class="col-sm-4 col-form-Label">City</label>
	<div class="col-sm-8">	
	<input type="text" name="city" required/>
	</div></div>	
	<button type="submit" class="btn btn-primary">Submit</button>
	<input type="button" value="Cancel" class="btn btn-secondary" onclick="history.go(-1);"/>
</div>	
<jsp:directive.include file="/jsp/common/footer.jsp"/>
<script type="text/javascript" src="/Computers4Sale/WebContent/js/customer-form.js"></script>
</form>

</body>
</html>