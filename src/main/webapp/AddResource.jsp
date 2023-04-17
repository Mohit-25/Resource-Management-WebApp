<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>User Registration Form</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/css/select2.min.css" />
<style>
.error
{
   
   color: red;
}
</style>
</head>
<body>


	<div class="container">
		<h1 class="text-center my-5">User Registration Form</h1>
		<form method="post" action="addresource">


			<div class="form-group">
				<label for="firstName">First Name:</label><span class='error'>${firstname}</span>
				<input type="text" class="form-control" id="firstName"
					name="firstName" required value="${user.firstName}">
			</div>

			<div class="form-group">
				<label for="lastName">Last Name:</label> <span class='error'>${lastname}</span> <input
					type="text" class="form-control" id="lastName" name="lastName"
					required value="${user.lastName}">
			</div>




			<div class="form-group">
				<label for="emailId">Email ID:</label><span class='error'>${email}</span> <input
					type="email" class="form-control" id="emailId" name="emailId"
					required value="${user.emailId}">
			</div>

			<div class="form-group">
				<label for="contactNo">Contact Number:</label><span class='error'>${number}</span>
				<input type="text" class="form-control" id="contactNo"
					name="contactNo" value="${user.contactNo}" required>
			</div>

			<div class="form-group">
				<label for="Gender">Gender:</label><br>
				<div class="form-check form-check-inline">
					<input type="radio" class="form-check-input" id="male"
						name="Gender" value="male" required> <label
						class="form-check-label" for="male">Male</label>
				</div>
				<div class="form-check form-check-inline">
					<input type="radio" class="form-check-input" id="female"
						name="Gender" value="female"> <label
						class="form-check-label" for="female">Female</label>
				</div>
			</div>

			<div class="form-group">
				<label for="experience">Experience:</label> <input type="number"
					class="form-control" id="experience" name="experience" min="0"
					max="50" required value="${user.experience}">
			</div>


			<div class="form-group">
				<label for="qualification">Qualification:</label><span class='error'>${qualification}</span>
				<select class="form-control select2" id="qualification" required
					name="qualification">

					<option value="select">Select</option>
					<option value="B.Tech/B.E">B.Tech/B.E</option>
					<option value="M.Tech/M.E">M.Tech/M.E</option>
					<option value="B.Sc/M.Sc">B.Sc/M.Sc</option>
					<option value="B.Com/M.Com">B.Com/M.Com</option>
					<option value="B.A">B.A</option>
				</select>
			</div>


			<div class="form-group">
				<label for="resumeUrl">Resume URL:</label> <input type="url"
					class="form-control" id="resumeUrl" name="resumeUrl" required
					value="${user.resumeUrl}">
			</div>



			<div class="form-group">
				<label for="mydb">Database:</label><br> 
				<select class="form-control" id="mydb" name="mydb[]" multiple
					required>
					<c:forEach items="${applicationScope.dblist}" var="db">
					${db}
					</c:forEach>
				</select>
				
			</div>
			
			

            <div class="form-group">
				<label for="mylan">Language:</label><br> 
				<select class="form-control" id="mylan" name="mylan[]" multiple
					required>
					<c:forEach items="${applicationScope.lanlist}" var="lan">
					${lan}
					</c:forEach>
				</select>
			</div>
			
			<div class="form-group">
				<label for="mytech">Technology:</label><br> 
				<select class="form-control" id="mytech" name="mytech[]" multiple
					required>
					<c:forEach items="${applicationScope.techlist}" var="tech">
					${tech}
					</c:forEach>
				</select>
			</div>
			



			<button type="submit" class="btn btn-primary">Submit</button>

			<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"></script>
			<script>
				$(document).ready(function() {
					$('#mydb').select2();
				});
				$(document).ready(function() {
					$('#mylan').select2();
				});
				$(document).ready(function() {
					$('#mytech').select2();
				});
			</script>
		</form>
	</div>
	
</body>
</html>