

<%@ include file = "schoolheader.jsp" %>
<div class="container-fluid signupmain">
	<div class="row">
		<c:set var="message"  value="${sessionScope.message}" scope="page"/>
		<c:if test="${message!=null}">
			<div id="snackbar1">
				<span class="glyphicon glyphicon-alert"></span> ${message}
			</div>
		</c:if>
		<form name="myform" method="post" action="/WebAddTeacher" onsubmit="return validateform()">  
	<div class="col-md-6 col-md-offset-3 signupinner">
	<div class="col-md-12">
		<h3 class="formheading">Add Teacher</h3>
		<input type="text" name="teacherName" placeholder="Enter Teacher Name...">
		<input type="email" name="emailId" placeholder="Enter Teacher Email Id.... ">
		<input type="text" name="mobileNumber" placeholder="Enter Teacher Mobile Number.... ">
	</div>
		<div class="col-md-8 col-md-offset-2">
		 <input type="submit" value="Add Teacher">
		 </div>
	</div>
	</form>
</div>

</div>

<%@ include file = "schoolfooter.jsp" %>
