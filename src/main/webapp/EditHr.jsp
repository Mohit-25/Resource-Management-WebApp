<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="editHrController" method="post">

     <input type="hidden" name="id" value="${param.id}">
     First Name: <input type="text" name="firstName" required value=${user.hrFirstName} ><span>${firstname}</span><br/><br/>
	 Last Name:  <input type="text" name="lastName"  required value=${user.hrLastName}><span>${lastname}</span><br/><br/>
     Email ID:  <input type="text" name="emailId"  required value=${user.hrEmail}><span>${email}</span><br/><br/>
     Password: <input type="text" name="password"  required value=${user.hrPassword}><span>${password}</span><br/><br/>
	 Gender:<input type="radio" name="gender" value="Male">Male
	       <input type="radio" name="gender" value="Female">Female<span>${gender}</span><br/><br/>
	 Contact No:<input type="tel" name="number" required value=${user.hrContact}><span>${number}</span><br/><br/>
	 Joining Date:<input type="date" required name="date" ><br/><br/>
	 <input type="submit" value="ADD">
	      
	  
</form>

</body>
</html>