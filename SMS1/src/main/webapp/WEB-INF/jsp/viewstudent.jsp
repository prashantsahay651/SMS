<%@ include file="schoolheader.jsp"%>
<c:set var="message" value="${message}" scope="page" />
<c:if test="${message!=null}">
	<div id="snackbar1">
		<span class="glyphicon glyphicon-alert"></span> ${message}
	</div>
	<%-- <c:set var="message" value="${null}" scope="session" /> --%>
</c:if>
<div class="container">


	<c:set var="student" value="${editstudent}" scope="page" />
	<c:if test="${student==null}">
		<c:redirect url="/schoolhome" />
	</c:if>

	<div class="row">
		<div class="col-md-12 signupinner">
			<div class="col-md-8 col-md-offset-2">
				<h3>Student Information</h3>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">Student Name</label>
				</div>
				<div class="col-md-8">
					<input type="text" name="studentName"
						value="${student.getStudentName()}" disabled="disabled">
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">Email Id</label>
				</div>
				<div class="col-md-8">
					<input type="text" name="emailId" value="${student.getEmailId()}"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel"> Mobile Number</label>
				</div>
				<div class="col-md-8">
					<input type="text" name="mobileNumber"
						value="${student.getMobileNumber()}" disabled="disabled">
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">Alternate Number</label>
				</div>
				<div class="col-md-8">
					<input type="text" name="alternateMobileNumber"
						value="${student.getAlternateMobileNumber()}" disabled="disabled">
				</div>
			</div>


			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">Address Line one</label>
				</div>
				<div class="col-md-8">
					<textarea name="addressLine1" disabled="disabled">${student.getAddressLine1()}</textarea>
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">Address Line Two</label>
				</div>
				<div class="col-md-8">
					<textarea name="addressLine2" disabled="disabled">${student.getAddressLine2()}</textarea>
				</div>
			</div>


			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">City</label>
				</div>
				<div class="col-md-8">
					<input type="text" name="city" value="${student.getCity()}"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">District</label>
				</div>
				<div class="col-md-8">
					<input type="text" name="district" value="${student.getDistrict()}"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">State</label>
				</div>
				<div class="col-md-8">
					<input type="text" name="state" value="${student.getState()}"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">pincode</label>
				</div>
				<div class="col-md-8">
					<input type="text" name="pinCode" value="${student.getPinCode()}"
						disabled="disabled">
				</div>
			</div>
		</div>

	</div>
	<c:set var="parent" value="${student.getParent()}" scope="page" />
	<div class="row">
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
					<input type="text" name="fathersName"
						value="${parent.getFathersName()}" disabled="disabled">
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">Mother's Name</label>
				</div>
				<div class="col-md-8">
					<input type="text" name="mothersName"
						value="${parent.getMothersName()}" disabled="disabled">
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">Email Id</label>
				</div>
				<div class="col-md-8">
					<input type="text" name="emailId" value="${parent.getEmailId()}"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">Father's Mobile Number</label>
				</div>
				<div class="col-md-8">
					<input type="text" name="mobileNumber"
						value="${parent.getMobileNumber()}" disabled="disabled">
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">Mother's Mobile Number</label>
				</div>
				<div class="col-md-8">
					<input type="text" name="alternateMobileNumber"
						value="${parent.getAlternateMobileNumber()}" disabled="disabled">
				</div>
			</div>

			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">Address Line one</label>
				</div>
				<div class="col-md-8">
					<textarea name="addressLine1" disabled="disabled">${parent.getAddressLine1()}</textarea>
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">Address Line Two</label>
				</div>
				<div class="col-md-8">
					<textarea name="addressLine2" disabled="disabled">${parent.getAddressLine2()}</textarea>
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">City</label>
				</div>
				<div class="col-md-8">
					<input type="text" name="city" value="${parent.getCity()}"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">District</label>
				</div>
				<div class="col-md-8">
					<input type="text" name="district" value="${parent.getDistrict()}"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">State</label>
				</div>
				<div class="col-md-8">
					<input type="text" name="state" value="${parent.getState()}"
						disabled="disabled">
				</div>
			</div>
			<div class="col-md-6">
				<div class="col-md-4">
					<label class="formlabel">pincode</label>
				</div>
				<div class="col-md-8">
					<input type="text" name="pinCode" value="${parent.getPinCode()}"
						disabled="disabled">
				</div>
			</div>
		</div>

	</div>
</div>
<%@ include file="schoolfooter.jsp"%>
