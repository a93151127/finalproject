<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Controller" method="post">
		帳號: <input type="text" id="account" name="account"/></br>
		密碼: <input type="password" id="password" name="password"/><br/>
		<input type="submit" value="submit"/>
	</form>
	<div id="txtHint">${msg}
	</div>
</body>
</html>