	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input{
		width:400px;
		height:40px;
	}
</style>
</head>
<body>
<jsp:include page="index.html"></jsp:include>
<br>
 <center>
 <form name='frm' action="userReg" method='POST'>
	<input type='text' name='name' value='' placeholder='Enter Name'/><br><br>
	<input type='text' name='email' value='' placeholder='Enter Email'/><br><br>
	<input type='text' name='contact' value='' placeholder='Enter Contact'/><br><br>
	<input type='text' name='username' value='' placeholder='Enter Username'/><br><br>
	<input type='text' name='password' value='' placeholder='Enter Password'/><br><br>
	<input type='submit' name='s' value='Register'/><br><br>
	</form>
 </center>
</body>
</html>