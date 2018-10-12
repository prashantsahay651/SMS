<%@ include file = "schoolheader.jsp" %>
<c:set var="message" value="${message}" scope="page" />
<c:if test="${message!=null}">
	<div id="snackbar1">
		<span class="glyphicon glyphicon-alert"></span> ${message}
	</div>
</c:if>
<c:set var="news1"  value="${news}"/>
<div class="container-fluid signupmain">

	<div class="row">
	<form name="myform" method="post" action="WebEditNews" onsubmit="return validateform()" enctype="multipart/form-data">  
	<div class="col-md-6 col-md-offset-3 signupinner">
	<div class="col-md-12">
		<h3 class="formheading">Edit News</h3>
		<input type="hidden" value="2" name="actionId">
		<input type="hidden" name="newsId" value="${news1.getNewsId()}">
		<input type="text" name="title" value="${news1.getTitle()}">
		<input type="text" name="newsBody" value="${news1.getNewsBody()}">
	</div>
		<div class="col-md-8 col-md-offset-2">
		 <input type="submit" value="Edit">
		 </div>
	</div>
	</form>
</div>

</div>
<%@ include file = "schoolfooter.jsp" %>
