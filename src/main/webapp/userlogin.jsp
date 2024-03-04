<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.html"></jsp:include>
<br><br>
<center>
	<form name='frm' action="userValidate" method='POST' >
	<input type='text' name='username' value='' style='width:400px;height:40px;'/><br><br>
	<input type='password' name='password' value='' style='width:400px;height:40px;'/><br><br>
	<input type='submit' name='s' value='Login User' style='width:400px;height:40px;'/><br><br>	
	</form>
</center>
</body>
</html>