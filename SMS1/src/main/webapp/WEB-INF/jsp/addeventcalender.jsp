<%@ include file = "schoolheader.jsp" %>
<c:set var="message" value="${message}" scope="page" />
<c:if test="${message!=null}">
	<div id="snackbar1">
		<span class="glyphicon glyphicon-alert"></span> ${message}
	</div>
</c:if>
<div class="container-fluid signupmain">

	<div class="row">
	<form name="myform" method="post" action="WebAddEventCalender" onsubmit="return validateform()" enctype="multipart/form-data">  
	<div class="col-md-6 col-md-offset-3 signupinner">
	<div class="col-md-12">
		<h3 class="formheading">Add Event Calendar</h3>
		<input type="text" name="eventName" placeholder="Enter Event Calender Name...">
		<input type="date" name="eventDate" placeholder="Enter News...">
	</div>
		<div class="col-md-8 col-md-offset-2">
		 <input type="submit" value="Submit">
		 </div>
	</div>
	</form>
</div>

</div>
<%@ include file = "schoolfooter.jsp" %>
