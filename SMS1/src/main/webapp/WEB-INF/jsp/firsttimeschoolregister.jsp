<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="WebAddSchool" method="POST" enctype="multipart/form-data">
<input type="text" name="schoolId">
<input type="text" name="addressLine1"><br>
<input type="text" name="addressLine2"><br>
<input type="text" name="city"><br>
<input type="text" name="district"><br>
<input type="text" name="state"><br>
<input type="text" name="pinCode"><br>
<input type="file" name="image1"/><br>
<input type="text" name="emailId"><br>
<input type="text" name="alternateEmailId"><br>
<input type="text" name="mobileNumber"><br>
<input type="text" name="alternateMobileNumber"><br>
<input type="text" name="phoneNumber"><br>
<input type="text" name="alternatePhoneNumber"><br>
<input type="text" name="password"><br>
<input type="submit" value="submit">
</form>
</body>
</html>