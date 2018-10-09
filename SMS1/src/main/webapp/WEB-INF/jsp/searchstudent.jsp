<%@ include file = "schoolheader.jsp" %>
<c:set var="message"  value="${message}" scope="page"/>
		<c:if test="${message!=null}">
			<div id="snackbar1">
				<span class="glyphicon glyphicon-alert"></span> ${message}
			</div>
			<%-- <c:set var="message" value="${null}" scope="session" /> --%>
		</c:if>
	<div class="container-fluid signupmain">
	
	<c:set var="students"  value="${requestScope.students}"/>
		<div class="row">
			<div class="col-md-6 col-md-offset-3 signupinner search">
				<div class="col-md-12">
					<h3>Search Student</h3>
				</div>
				<div class="col-md-12">
					<form  name="myform" method="post" action="/WebSearchStudent"
						onsubmit="return validateform()"  onKeyPress="user_change()">
						<input type="text" name="studentName"
							placeholder="Enter Student Name"> <input type="submit"
							value="Search">
					</form>
				</div>
			</div>

		</div>
		
		<c:if test="${students!=null}">
		<div class="row">
			<div class="col-md-10 col-md-offset-1 signupinner">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Student Name</th>
							<th>Email Id</th>
							<th>Mobile Number</th>
							<th>Father's Name</th>
							<th colspan="2">Action</th>
						</tr>
					</thead>

					<tbody class="company1">
					<c:forEach var="student" items="${students}" varStatus="counter">
						<tr>
							<td>${student.getStudentName()}</td>
							<td>${student.getLogin().getEmailId()}</td>
							<td>${student.getMobileNumber()}</td>
							<td>${student.getParent().getFathersName()}</td>
							<td>
								<div style="float: left; width: 30%; margin-left: 2%;">
									<form method="post" action="/WebEditStudent">
										<input type="hidden" value="0" name="actionId">
										<input type="hidden" value="${student.getStudentId()}" name="studentId">
										<button type="submit" class="btn btn-info">Edit</button>
									</form>
								</div>
								<div style="float: left; width: 30%; margin-left: 2%;">
									<form method="post" action="/WebViewStudent">
										<input type="hidden" value="0" name="actionId">
										<input type="hidden" value="${student.getStudentId()}" name="studentId">
										<button type="submit" class="btn btn-success">View</button>
									</form>
								</div>
								<div style="float: left; width: 30%; margin-left: 2%;">
									<form method="post" action="DeleteController">
										<input type="hidden" value="${company.getCompanyId()}"
											name="companyid">
										<button type="submit" class="btn btn-danger">Delete</button>
									</form>
								</div>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		</c:if>
	</div>
	<%@ include file = "schoolfooter.jsp" %>
