<%@ include file = "schoolheader.jsp" %>
<c:set var="message" value="${message}" scope="page" />
<c:if test="${message!=null}">
	<div id="snackbar1">
		<span class="glyphicon glyphicon-alert"></span> ${message}
	</div>
</c:if>
<c:set var="classes"  value="${requestScope.classes}" scope="page"/>
<div class="container-fluid signupmain">

	<div class="row">
	<form name="myform" method="post" action="WebAddSection" onsubmit="return validateform()" enctype="multipart/form-data">  
	<div class="col-md-6 col-md-offset-3 signupinner">
	<div class="col-md-12">
		<h3 class="formheading">Add Class</h3>
		<select name="classId" >
			<option selected disabled="disabled">Select Class...</option>
			<c:forEach var="class1" items="${classes}" varStatus="counter">
			<option value="${class1.getClassId()}">${class1.getClassName()}</option>
			</c:forEach>
		</select>
		<select name="sectionName" >
			<option selected disabled="disabled">Select Section...</option>
			<option value="A">A</option>
			<option value="B">B</option>
			<option value="C">C</option>
			<option value="D">D</option>
		</select>
	</div>
		<div class="col-md-8 col-md-offset-2">
		 <input type="submit" value="Submit">
		 </div>
	</div>
	</form>
</div>

</div>
<%@ include file = "schoolfooter.jsp" %>
