<%@ include file = "schoolheader.jsp" %>

<div class="container">
   <c:set var="message"  value="${message}" scope="page"/>
		<c:if test="${message!=null}">
			<div id="snackbar1">
				<span class="glyphicon glyphicon-alert"></span> ${message}
			</div>
			<%-- <c:set var="message" value="${null}" scope="session" /> --%>
		</c:if>

<c:set var="teacher"  value="${teacher}" scope="page"/>

<c:if test="${teacher==null}">
			 <c:redirect url = "/schoolhome"/>
		</c:if>

<div class="row">
    <form name="myform" method="post" action="/WebEditTeacher" onsubmit="return validateform()" > 
    <input type="hidden" name="teacherId" value="${teacher.getTeacherId()}">
    <input type="hidden" name="actionId" value="1"> 
    <div class="col-md-12 signupinner">
    <div class="col-md-8 col-md-offset-2">
        <h3>Teacher Information</h3>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">Student Name</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="teacherName" value="${teacher.getTeacherName()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">Email Id</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="emailId" value="${teacher.getEmailId()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel"> Mobile Number</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="mobileNumber" value="${teacher.getMobileNumber()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">Alternate Number</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="alternateMobileNumber" value="${teacher.getAlternateMobileNumber()}">
    </div>
    </div>
    
    
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">Address Line one</label>
    </div>
    <div class="col-md-8">
        <textarea name="addressLine1">${teacher.getAddressLine1()}</textarea>
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">Address Line Two</label>
    </div>
    <div class="col-md-8">
        <textarea name="addressLine2">${teacher.getAddressLine2()}</textarea>
    </div>
        </div>
        
        
        <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">City</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="city" value="${teacher.getCity()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">District</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="district" value="${teacher.getDistrict()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">State</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="state" value="${teacher.getState()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">pincode</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="pinCode" value="${teacher.getPinCode()}">
    </div>
    </div> 
    
    
    <div class="col-md-6 col-md-offset-3">
    <input type="submit" value="Edit Teacher">
    </div> 
    </div>
    </form>
</div>

 
</div>




<%@ include file = "schoolfooter.jsp" %>