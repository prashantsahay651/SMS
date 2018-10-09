
<%@ include file = "indexheader.jsp" %>
<div class="container-fluid signupmain">
<c:set var="schools"  value="${requestScope.schools}"/>
	<div class="row">
	<form name="myform" method="post" action="WebRegisterStudent" onsubmit="return validateform()" enctype="multipart/form-data">  
	<div class="col-md-6 col-md-offset-3 signupinner">
	<div class="col-md-12">
		<h3 class="formheading">Student Registration</h3>
		<select name="schoolId" class="user1" onchange="user_change()">
			<option selected disabled="disabled">Select Class...</option>
			<c:forEach var="school" items="${schools}" varStatus="counter">
			<option value="${school.getSchoolId()}">${school.getSchoolName()}</option>
			</c:forEach>
		</select>
		<select class="company1" name="classId"  onchange="user1_change()">
				<option selected="selected">--Select Company--</option>
		</select>
		<select class="company11" name="sectionId">
				<option selected="selected">--Select Company--</option>
		</select>
		<input type="text" name="studentName" placeholder="Enter Student Name..">
		<input type="text" name="studentMobileNumber" placeholder="Enter Student Mobile Number..">
		<input type="email" name="studentEmailId" placeholder="Enter Student Email Id...">
		<label>Parent Already Registered? </label> <input type="checkbox" id="trigger" name="question">
		<div id="hidden_fields">
		<input type="email" name="fathersName" placeholder="Enter Father's Name...">
		<input type="email" name="fatherMobileNumber" placeholder="Enter Parent Mobile Number...">
		</div>
		<input type="email" name="fatherEmailId" placeholder="Enter Parent Email ID...">
	</div>
		<div class="col-md-8 col-md-offset-2">
		 <input type="submit" value="Submit">
		 </div>
	</div>
	</form>
</div>

</div>
<script>
function user_change()
{
    var user1 = $(".user1").val();
 
    $.ajax({
        type: "POST",
        url: "WebGetClass",
        data: "user_id="+user1,
        cache: false,
        success: function(response)
        {
            $(".company1").html(response);
        }
    });
}
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
<%@ include file = "indexfooter.jsp" %>