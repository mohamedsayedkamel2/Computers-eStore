<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<jsp:directive.include file="/jsp/common/head.jsp"/>
<title>Admin - Create User</title>
</head>
<body>
<jsp:directive.include file="/jsp/common/header.jsp"/>
<form style="max-width: 700px; margin: 0 auto" method="post" action="/Computers/admin/create_user">
<div class="border border-secondary rounded p-3">
		<div class="form-group-row">
<label class="col-sm-4 col-form-Label">Name</label>
	<div class="col-sm-8">
	<input name="name" type="text" value="${user.fullName}" required/>
	</div></div>
		<div class="form-group-row">
<label class="col-sm-4 col-form-Label">Email</label>
	<div class="col-sm-8">
	<input name="email" type="email" value="${user.email}" required />
	</div></div>
		<div class="form-group-row">
<label class="col-sm-4 col-form-Label">Password</label>
	<div class="col-sm-8">
	<input name="password" type="password" value="${user.password}" required />
	</div></div>
	<button type="submit" class="btn btn-primary">Submit</button>
	<input type="button" value="Cancel" class="btn btn-secondary" onclick="history.go(-1);"/>
<jsp:directive.include file="/jsp/common/footer.jsp"/>
<script type="text/javascript" src="/Computers/WebContent/js/customer-form.js"></script>
</div>
</form>
</body>