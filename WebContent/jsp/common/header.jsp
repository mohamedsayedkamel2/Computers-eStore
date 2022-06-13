<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
<div class="container-fluid">
<nav class="navbar navbar-expand-lg bg-dark navbar-dark">
  <a class="navbar-brand" href="./"><font color="yellow">Computers</font><font color="blue">4</font><font color="#FF2D00">Sale</font></a>
  <div>
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="./">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./">Categories</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./ram">Ram</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./hdd">HDD</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./motherboard">Motherboard</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./case">Case</a>
      </li>                        
      <c:if test="${loggedCustomer == null}">
       <li class="nav-item">
        <a class="nav-link" href="./register">Register</a>
      </li>      
       <li class="nav-item">
        <a class="nav-link" href="./login">Login</a>
      </li>
       </c:if>
       <c:if test="${loggedCustomer != null}"> 
       	<li class="nav-item">
       		<a class="nav-link" href="./profile">Your Profile</a>
       	</li>
       	<li class="nav-item">
       		<a class="nav-link" href="./logout">Logout</a>
       	</li>       	
      </c:if> 		
    </ul>
  </div>
</nav>
</div>
</header>