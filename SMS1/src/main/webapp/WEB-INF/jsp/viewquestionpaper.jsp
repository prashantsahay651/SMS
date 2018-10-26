<%@ include file = "schoolheader.jsp" %>
<c:set var="message"  value="${message}" scope="page"/>
		<c:if test="${message!=null}">
			<div id="snackbar1">
				<span class="glyphicon glyphicon-alert"></span> ${message}
			</div>
			<%-- <c:set var="message" value="${null}" scope="session" /> --%>
		</c:if>
	<div class="container-fluid signupmain">
	
	<c:set var="classes"  value="${requestScope.classes}"/>
		
		
		
		<div class="row">
			<div class="col-md-10 col-md-offset-1 signupinner">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Class</th>
							<th>Subject</th>
							<th>File Name</th>
							<th>File Type</th>
							<th>Discription</th>
							<th>Download</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody class="company1">
					<c:forEach var="class1" items="${classes}" varStatus="counter">
						<c:forEach var="questionPaper" items="${class1.getQuestionPapers()}" varStatus="counter">
						<tr>
							<td>${questionPaper.getClass1().getClassName()}</td>
							<td>${questionPaper.getSubject().getSubjectName()}</td>
							<td>${questionPaper.getFileName()}</td>
							<td>${questionPaper.getFileType()}</td>
							<td>${questionPaper.getDiscription()}</td>
							<td><a href="data:${questionPaper.getFileType()};base64,${questionPaper.getBase64Encoded()}" download>Download</a></td>
							<td>
								<div style="float: left; width: 100%; margin-left: 2%;">
									<form method="post" action="WebDeleteEventCalender">
										<input type="hidden" value="${questionPaper.getId()}"
											name="eventCalenderId">
										<button type="submit" class="btn btn-danger">Delete</button>
									</form>
								</div>
							</td>
						</tr>
						</c:forEach>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	
	</div>
	<%@ include file = "schoolfooter.jsp" %>
