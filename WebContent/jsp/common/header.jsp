<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
<div class="container-fluid">
<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
  <a class="navbar-brand" href="/Computers4Sale/"><font color="yellow">Computers</font><font color="blue">4</font><font color="#FF2D00">Sale</font></a>
  <div>
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/Computers4Sale/">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/Computers4Sale/">Categories</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/Computers4Sale/">Profile</a>
      </li>
      <c:if test="${loggedCustomer == null}">
       <li class="nav-item">
        <a class="nav-link" href="/Computers4Sale/register">Register</a>
      </li>      
       <li class="nav-item">
        <a class="nav-link" href="/Computers4Sale/login">Login</a>
      </li>
       </c:if>
       <c:if test="${loggedCustomer != null}">
       	<li class="nav-item">
       		<a class="nav-link" href="/Computers4Sale/view_profile">Welcome ${loggedCustomer.name}</a>
       	</li>
      </c:if> 		
    </ul>
  </div>
</nav>
</div>
</header>