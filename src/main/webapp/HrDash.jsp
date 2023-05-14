<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <%  ArrayList<String[]> dblist=(ArrayList<String[]>)request.getAttribute("dlist");
   ArrayList<String[]> lanlist=(ArrayList<String[]>)request.getAttribute("llist");
   ArrayList<String[]> techlist=(ArrayList<String[]>)request.getAttribute("tlist");
     int i=0;
     int j=0;
     int k=0;
   
     %>
<button><a href="SearchResource.jsp" style="text-decoration: none">Search Resource</a></button> 
<button><a href="AddResource.jsp" style="text-decoration: none">Add Resources</a></button>
<table border="1">
    <tr>
      <th>Id</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Email Id</th>
      <th>Contact No</th>
<!--       <th>Gender</th> -->
      <th>Experience</th>
      <th>Qualification</th>
      <th>Resume URL</th>
      <th>Database</th>
   <th>Language</th>
      <th>Technology</th>
      <th>Action</th>
    </tr>
   
      <c:forEach items="${users}" var="user">
    
   
   <tr>
       <td>${user.userId}</td>
       <td>${user.firstName}</td>
       <td>${user.lastName}</td>
       <td>${user.emailId}</td>
       <td>${user.contactNo}</td>
<%--        <td>${user.Gender}</td> --%>
       <td>${user.experience}</td>
       <td>${user.qualification}</td>
       <td>${user.resumeUrl}</td>
       
       
       
     
      <td> <% String []d=dblist.get(i++); %> 
            |
           <% for(String s:d){%><%=s==null?"":s+" |" %> <% }%> </td>
      <td> <% String []l=lanlist.get(j++); %> 
            |
           <% for(String s:l){%><%=s==null?"":s+" |" %> <% }%> </td>
      <td> <% String []t=techlist.get(k++); %> 
            |
           <% for(String s:t){%><%=s==null?"":s+" |" %> <% }%> </td>
              
      

       
       
         <td><button><a href="view?id=${user.userId}" style="text-decoration: none">View HR</a></button> 
         |
         <button><a href="deleteresource?id=${user.userId}" style="text-decoration: none">Delete HR</a></button> 
         |
         <button><a href="editHrController?id=${user.userId}" style="text-decoration: none">Edit HR</a></button>
       
       
    </tr>  
   
   </c:forEach>
         
</table>
</body>
</html>