<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Welcome Back ${user.adminName}<br/>

 

<button><a href="AddHr.jsp" style="text-decoration: none">Add HR</a></button>

<table border="1">
    <tr>
      <th>Id</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Email Id</th>
      <th>Contact No</th>
      <th>Action</th>
      
   </tr>
   
   
   <c:forEach items="${users}" var="user">

   
   <tr>
       <td>${user.hrId}</td>
       <td>${user.hrFirstName}</td>
       <td>${user.hrLastName}</td>
       <td>${user.hrEmail}</td>
       <td>${user.hrContact}</td>
       <td><button><a href="view?id=${user.hrId}" style="text-decoration: none">View HR</a></button>
       |
       <button><a href="delete?id=${user.hrId}" style="text-decoration: none">Delete HR</a></button>
       
       
       
    </tr>  
   
   </c:forEach>
         
</table>
<br><br>

</body>
</html>