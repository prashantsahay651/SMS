<%@ include file = "schoolheader.jsp" %>
<c:set var="message"  value="${message}" scope="page"/>
		<c:if test="${message!=null}">
			<div id="snackbar1">
				<span class="glyphicon glyphicon-alert"></span> ${message}
			</div>
			<%-- <c:set var="message" value="${null}" scope="session" /> --%>
		</c:if>
	<div class="container-fluid signupmain">
	
	<c:set var="registrations"  value="${sessionScope.registrations}"/>
		<div class="row">
			<div class="col-md-10 col-md-offset-1 signupinner">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Student Name</th>
							<th>Student Mobile Number</th>
							<th>Student Email ID</th>
							<th>Class/Section</th>
							<th colspan="2">Action</th>
						</tr>
					</thead>

					<tbody class="company1">
					<c:forEach var="registration" items="${registrations}" varStatus="counter">
						<tr>
							<td>${registration.getStudentName()}</td>
							<td>${registration.getStudentMobileNumber()}</td>
							<td>${registration.getStudentEmailId()}</td>
							<td>${registration.getClassSection()}</td>
							
							<td>
								<div style="float: left; width: 30%; margin-left: 2%;">
									<form method="post" action="/WebAcceptStudentRequest">
										<input type="hidden" value="${registration.getId()}" name="id">
										<button type="submit" class="btn btn-info">Accept</button>
									</form>
								</div>
								<div style="float: left; width: 30%; margin-left: 2%;">
									<form method="post" action="/WebDeleteStudentRequest">
										<input type="hidden" value="${registration.getId()}"
											name="id">
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
	</div>
	<%@ include file = "schoolfooter.jsp" %>
