<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="AddHr" method="post">
  
     First Name: <input type="text" name="firstName" ><br/><br/>
	 Last Name:  <input type="text" name="lastName" ><br/><br/>
     Email ID:  <input type="email" name="emailId"><br/><br/>
     Password: <input type="password" name="password"><br/><br/>
	 Gender:<input type="radio" name="gender" value="Male">Male
	       <input type="radio" name="gender" value="Female">Female<br/><br/>
	 Contact No:<input type="number" name="number" minlength="10" maxlength="10"><br/><br/>
	 Joining Date:<input type="date" name="date" ><br/><br/>
	 <input type="submit" value="ADD">
	      
	  
</form>
</body>
</html>