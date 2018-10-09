<%@ include file = "schoolheader.jsp" %>
<c:set var="message" value="${message}" scope="page" />
<c:if test="${message!=null}">
	<div id="snackbar1">
		<span class="glyphicon glyphicon-alert"></span> ${message}
	</div>
</c:if>
<div class="container-fluid signupmain">

	<div class="row">
	<form name="myform" method="post" action="WebAddStudent" onsubmit="return validateform()" enctype="multipart/form-data">  
	<div class="col-md-6 col-md-offset-3 signupinner">
	<div class="col-md-12">
		<h3 class="formheading">Add Student</h3>
		<input type="text" name="studentName" placeholder="Enter Student Name..">
		<input type="text" name="mobileNumber" placeholder="Enter Student Mobile Number..">
		<input type="email" name="emailId" placeholder="Enter Student Email Id...">
		<label>Parent Already Registered? </label> <input type="checkbox" id="trigger" name="question">
		<div id="hidden_fields">
		<input type="email" name="fathersName" placeholder="Enter Father's Name...">
		<input type="email" name="parentPhoneNumber" placeholder="Enter Parent Mobile Number...">
		</div>
		<input type="email" name="parentEmailId" placeholder="Enter Parent Email ID...">
		
	</div>
		<div class="col-md-8 col-md-offset-2">
		 <input type="submit" value="Submit">
		 </div>
	</div>
	</form>
</div>

</div>
<%@ include file = "schoolfooter.jsp" %>
