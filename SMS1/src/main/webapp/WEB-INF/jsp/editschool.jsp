<%@ include file="schoolheader.jsp"%>
<c:set var="message" value="${message}" scope="page" />
<c:if test="${message!=null}">
	<div id="snackbar1">
		<span class="glyphicon glyphicon-alert"></span> ${message}
	</div>
	<%-- <c:set var="message" value="${null}" scope="session" /> --%>
</c:if>

<c:set var="school" value="${sessionScope.school}" scope="page" />

<div class="container signupmain">
	<div class="row">
		<form name="myform" method="Post" action="WebEditSchool"
			onsubmit="return validateform()" enctype="multipart/form-data">
			<input type="hidden" name="schoolId" value="${school.getSchoolId()}">
			<input type="hidden" name="actionId" value="0">
			<div class="col-md-12 signupinner">
				<div class="col-md-8 col-md-offset-2">
					<h3>Teacher Information</h3>
				</div>
				<div class="col-md-6">
					<div class="col-md-4">
						<label class="formlabel">School Name</label>
					</div>
					<div class="col-md-8">
						<input type="text" name="schoolName"
							value="${school.getSchoolName()}">
					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-4">
						<label class="formlabel">Email Id</label>
					</div>
					<div class="col-md-8">
						<input type="text" name="emailId" value="${school.getEmailId()}">
					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-4">
						<label class="formlabel"> Mobile Number</label>
					</div>
					<div class="col-md-8">
						<input type="text" name="mobileNumber"
							value="${school.getMobileNumber()}">
					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-4">
						<label class="formlabel">Alternate Number</label>
					</div>
					<div class="col-md-8">
						<input type="text" name="alternateMobileNumber"
							value="${school.getAlternateMobileNumber()}">
					</div>
				</div>


				<div class="col-md-6">
					<div class="col-md-4">
						<label class="formlabel">Address Line one</label>
					</div>
					<div class="col-md-8">
						<textarea name="addressLine1">${school.getAddressLine1()}</textarea>
					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-4">
						<label class="formlabel">Address Line Two</label>
					</div>
					<div class="col-md-8">
						<textarea name="addressLine2">${school.getAddressLine2()}</textarea>
					</div>
				</div>


				<div class="col-md-6">
					<div class="col-md-4">
						<label class="formlabel">City</label>
					</div>
					<div class="col-md-8">
						<input type="text" name="city" value="${school.getCity()}">
					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-4">
						<label class="formlabel">District</label>
					</div>
					<div class="col-md-8">
						<input type="text" name="district" value="${school.getDistrict()}">
					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-4">
						<label class="formlabel">State</label>
					</div>
					<div class="col-md-8">
						<input type="text" name="state" value="${school.getState()}">
					</div>
				</div>
				<div class="col-md-6">
					<div class="col-md-4">
						<label class="formlabel">pincode</label>
					</div>
					<div class="col-md-8">
						<input type="text" name="pinCode" value="${school.getPinCode()}">
					</div>
				</div>


				<div class="col-md-6 col-md-offset-3">
					<input type="submit" value="Edit School">
				</div>
			</div>
		</form>
	</div>
</div>
<%@ include file="schoolfooter.jsp"%>
