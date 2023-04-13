<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="AuthenticationController" method="post">

   Enter Email<input type="email" name="adminEmail" value=${auser.adminEmail}><br/><br/>
   Enter Password<input type="password" name="adminPass" value=${auser.adminPassword}><br/><br/>
   <input type="submit" value="Login">
</form>
  ${error}
</body>
</html>