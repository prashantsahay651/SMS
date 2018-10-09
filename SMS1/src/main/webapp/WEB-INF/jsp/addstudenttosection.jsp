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
	<form name="myform" method="post" action="WebAddStudentToSection" onsubmit="return validateform()" enctype="multipart/form-data">  
	<div class="col-md-6 col-md-offset-3 signupinner">
	<div class="col-md-12">
		<h3 class="formheading">Add Class</h3>
		<select class="company1" name="classId" onchange="user1_change()">
			<option selected disabled="disabled">Select Class...</option>
			<c:forEach var="class1" items="${classes}" varStatus="counter">
			<option value="${class1.getClassId()}">${class1.getClassName()}</option>
			</c:forEach>
		</select>
		<select class="company11" name="sectionId">
				<option selected="selected">Select Section</option>
		</select>
		
		<select  name="studentId">
			<option selected disabled="disabled">Select Subject...</option>
			<c:set var="students"  value="${requestScope.students}" scope="page"/>
			<c:forEach var="student" items="${students}" varStatus="counter">
			<option value="${student.getStudentId()}">${student.getStudentName()}</option>
			</c:forEach>
		</select>
		
	</div>
		<div class="col-md-8 col-md-offset-2">
		 <input type="submit" value="Submit">
		 </div>
	</div>
	</form>
</div>

</div>
<script>
function user1_change()
{
    var user1 = $(".company1").val();
 
    $.ajax({
        type: "POST",
        url: "WebGetSection",
        data: "user_id="+user1,
        cache: false,
        success: function(response)
        {
            $(".company11").html(response);
        }
    });
}
</script>
<%@ include file = "schoolfooter.jsp" %>
