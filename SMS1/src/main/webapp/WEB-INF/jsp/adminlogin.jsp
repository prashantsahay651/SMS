<%@ include file = "indexheader.jsp" %>

<div class="container-fluid signupmain">
<c:if test="${message!=null}">
	<div id="snackbar1">
		<span class="glyphicon glyphicon-alert"></span> ${message}
	</div>
	<%-- <c:set var="message" value="${null}" scope="session" /> --%>
</c:if>
	<div class="row">
	<form name="myform" method="post" action="WebAdminlLogin" onsubmit="return validateform()" enctype="multipart/form-data">  
	<div class="col-md-6 col-md-offset-3 signupinner">
	<div class="col-md-12">
		<h3 class="formheading">Admin Login</h3>
		<input type="email" name="emailId" placeholder="Enter Your Email Id..">
		<input type="password" name="password" placeholder="Enter Your Password..">
	</div>
		<div class="col-md-8 col-md-offset-2">
		 <input type="submit" value="Login">
		 </div>
	</div>
	</form>
</div>

</div>

<%@ include file = "indexfooter.jsp" %>