<%@ include file = "schoolheader.jsp" %>
   <c:set var="message"  value="${message}" scope="page"/>
		<c:if test="${message!=null}">
			<div id="snackbar1">
				<span class="glyphicon glyphicon-alert"></span> ${message}
			</div>
			<%-- <c:set var="message" value="${null}" scope="session" /> --%>
		</c:if>



   

<c:set var="student"  value="${editstudent}" scope="page"/>
<c:set var="parent"  value="${student.getParent()}" scope="page"/>
<c:if test="${student==null}">
			 <c:redirect url = "/schoolhome"/>
		</c:if>
		<div class="container">
<div class="row">
    <form name="myform" method="post" action="/WebEditStudent" onsubmit="return validateform()" > 
    <input type="hidden" name="studentId" value="${student.getStudentId()}">
    <input type="hidden" name="actionId" value="1"> 
    <div class="col-md-12 signupinner">
    <div class="col-md-8 col-md-offset-2">
        <h3>Student Information</h3>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">Student Name</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="studentName" value="${student.getStudentName()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">Email Id</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="emailId" value="${student.getLogin().getEmailId()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel"> Mobile Number</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="mobileNumber" value="${student.getMobileNumber()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">Alternate Number</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="alternateMobileNumber" value="${student.getAlternateMobileNumber()}">
    </div>
    </div>
    
    
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">Address Line one</label>
    </div>
    <div class="col-md-8">
        <textarea name="addressLine1">${student.getAddressLine1()}</textarea>
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">Address Line Two</label>
    </div>
    <div class="col-md-8">
        <textarea name="addressLine2">${student.getAddressLine2()}</textarea>
    </div>
        </div>
        
        
        <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">City</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="city" value="${student.getCity()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">District</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="district" value="${student.getDistrict()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">State</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="state" value="${student.getState()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">pincode</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="pinCode" value="${student.getPinCode()}">
    </div>
    </div> 
    
    
    <div class="col-md-6 col-md-offset-3">
    <input type="submit" value="Edit Student">
    </div> 
    </div>
    </form>
</div>

 <div class="row">
    <form name="myform" method="post" action="/WebEditParent" onsubmit="return validateform()" > 
    <input type="hidden" name="studentId" value="${student.getStudentId()}">
     <input type="hidden" name="parentId" value="${parent.getParentId()}">
    <input type="hidden" name="actionId" value="1"> 
    <div class="col-md-12 signupinner">
    <div class="col-md-8 col-md-offset-2">
        <h3>Parent Information</h3>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">Father's Name</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="fathersName" value="${parent.getFathersName()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">Mother's Name</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="mothersName" value="${parent.getMothersName()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">Email Id</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="emailId" value="${parent.getLogin().getEmailId()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">Father's Mobile Number</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="mobileNumber" value="${parent.getMobileNumber()}">
    </div>
    </div>
     <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">Mother's Mobile Number</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="alternateMobileNumber" value="${parent.getAlternateMobileNumber()}">
    </div>
    </div>
    
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">Address Line one</label>
    </div>
    <div class="col-md-8">
        <textarea name="addressLine1">${parent.getAddressLine1()}</textarea>
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">Address Line Two</label>
    </div>
    <div class="col-md-8">
        <textarea name="addressLine2">${parent.getAddressLine2()}</textarea>
    </div>
        </div>
      <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">City</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="city" value="${parent.getCity()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">District</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="district" value="${parent.getDistrict()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">State</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="state" value="${parent.getState()}">
    </div>
    </div>
    <div class="col-md-6">
    <div class="col-md-4">
        <label class="formlabel">pincode</label>
    </div>
    <div class="col-md-8">
        <input type="text" name="pinCode" value="${parent.getPinCode()}">
    </div>
    </div> 
    <div class="col-md-6 col-md-offset-3">
    <input type="submit" value="Edit Parent">
    </div> 
    </div>
    </form>
</div>
</div>
<%@ include file = "schoolfooter.jsp" %>
 