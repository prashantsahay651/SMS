<%@ include file = "schoolheader.jsp" %>
<c:set var="message"  value="${message}" scope="page"/>
		<c:if test="${message!=null}">
			<div id="snackbar1">
				<span class="glyphicon glyphicon-alert"></span> ${message}
			</div>
			<%-- <c:set var="message" value="${null}" scope="session" /> --%>
		</c:if>
	<div class="container-fluid signupmain">
	
	<c:set var="eventCalenders"  value="${requestScope.eventCalenders}"/>
		
		
		
		<div class="row">
			<div class="col-md-10 col-md-offset-1 signupinner">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Event Name</th>
							<th>Date</th>
							<th colspan="2">Action</th>
						</tr>
					</thead>

					<tbody class="company1">
					<c:forEach var="eventCalender" items="${eventCalenders}" varStatus="counter">
						<tr>
							<td>${eventCalender.getEventName()}</td>
							<td>${eventCalender.getEventDate()}</td>
							<td>
								<div style="float: left; width: 30%; margin-left: 2%;">
									<form method="post" action="WebDeleteEventCalender">
										<input type="hidden" value="${eventCalender.getEventCalenderId()}"
											name="eventCalenderId">
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
