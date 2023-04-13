<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
    <tr>
      <th>Id</th>
      <td>${user.hrId}</td>
    </tr>
    <tr>
      <th>First Name</th>
      <td>${user.hrFirstName}</td>
    </tr>
    <tr>
      <th>Last Name</th>
      <td>${user.hrLastName}</td>
    </tr>
    <tr>
      <th>Email Id</th>
      <td>${user.hrEmail}</td>
    </tr>
    <tr>
      <th>Password</th>
      <td>${user.hrPassword}</td>
    </tr>
    <tr>
      <th>Gender</th>
      <td>${user.hrGender}</td>
    </tr>
    <tr>
      <th>Contact No</th>
      <td>${user.hrContact}</td>
    </tr>
    <tr>
      <th>Join Date</th>
      <td>${user.hrJoinDate}</td>
    </tr>
    
 </table>
 

</body>
</html>