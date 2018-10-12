<%@ include file = "schoolheader.jsp" %>

<div class="container-fluid signupmain">
	<c:set var="message"  value="${message}" scope="page"/>
		<c:if test="${message!=null}">
			<div id="snackbar1">
				<span class="glyphicon glyphicon-alert"></span> ${message}
			</div>
			<%-- <c:set var="message" value="${null}" scope="session" /> --%>
		</c:if>
	<c:set var="news"  value="${news}"/>
		
		
		<c:if test="${news!=null}">
		<div class="row">
			<div class="col-md-10 col-md-offset-1 signupinner">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Title</th>
							<th>News Body</th>
							<th>Date And Time</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody class="company1">
					<c:forEach var="news1" items="${news}" varStatus="counter">
						<tr>
							<td>${news1.getTitle()}</td>
							<td>${news1.getNewsBody()}</td>
							<td>${news1.getTimestamp()}</td>
							<td>
								<div style="float: left; width: 48%; margin-left: 2%;">
									<form method="Post" action="WebEditNews">
										<input type="hidden" value="1" name="actionId">
										<input type="hidden" value="${news1.getNewsId()}" name="newsId">
										<button type="submit" class="btn btn-info">Edit</button>
									</form>
								</div>
								<div style="float: left; width: 48%; margin-left: 2%;">
									<form method="post" action="WebDeleteNews">
										<input type="hidden" value="${news1.getNewsId()}"
											name="newsId">
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