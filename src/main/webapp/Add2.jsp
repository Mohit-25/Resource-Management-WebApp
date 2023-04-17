<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration Form</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.1.0/css/select2.min.css">
<style>
body {
	background-color: #f8f9fa;
}

.form-control:focus {
	border-color: #80bdff;
	box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
}

.btn-primary {
	background-color: #007bff;
	border-color: #007bff;
}

.btn-primary:hover {
	background-color: #0069d9;
	border-color: #0062cc;
}
</style>

</head>

<body>

	<div class="container my-5">
		<div class="row justify-content-center">
			<div class="col-lg-8">
				<div class="card shadow-lg border-0 rounded-lg">
					<div class="card-header">
						<h3 class="text-center font-weight-light my-4">User
							Registration Form</h3>
					</div>
					<div class="card-body">
						<form method="post" action="register.jsp">
							<div class="form-group">
								<label for="userId">User ID:</label> <input type="text"
									class="form-control" id="userId" name="userId" required>
							</div>

							<div class="form-row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="firstName">First Name:</label> <input type="text"
											class="form-control" id="firstName" name="firstName" required>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="lastName">Last Name:</label> <input type="text"
											class="form-control" id="lastName" name="lastName" required>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="emailId">Email ID:</label> <input type="email"
									class="form-control" id="emailId" name="emailId" required>
							</div>

							<div class="form-group">
								<label for="contactNo">Contact Number:</label> <input type="tel"
									class="form-control" id="contactNo name=" contactNo" required>
							</div>

							<div class="form-row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="Gender">Gender:</label> <select
											class="form-control" id="Gender" name="Gender" required>
											<option value="">Select Gender</option>
											<option value="Male">Male</option>
											<option value="Female">Female</option>
											<option value="Other">Other</option>
										</select>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="experience">Experience:</label> <input type="text"
											class="form-control" id="experience" name="experience"
											required>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="qualification">Qualification:</label> <input
									type="text" class="form-control" id="qualification"
									name="qualification" required>
							</div>

							<div class="form-group">
								<label for="resumeUrl">Resume URL:</label> <input type="url"
									class="form-control" id="resumeUrl" name="resumeUrl" required>
							</div>

							<div class="form-group">
								<label for="languages">Languages:</label> <select
									class="form-control select2" id="languages" name="languages[]"
									multiple="multiple" required>
									<option value="English">English</option>
									<option value="Spanish">Spanish</option>
									<option value="French">French</option>
									<option value="German">German</option>
									<option value="Chinese">Chinese</option>
								</select>
							</div>
							<div class="form-group">
								<label for="mySelect">Languages:</label><br> <select
									class="form-control" id="mySelect" name="mySelect[]" multiple>
									<option value="option1">Option 1</option>
									<option value="option2">Option 2</option>
									<option value="option3">Option 3</option>
								</select>
							</div>

							<button type="submit" class="btn btn-primary">Submit</button>

							<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
							<script
								src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"></script>
							<script>
								$(document).ready(function() {
									$('#mySelect').select2();
								});
							</script>
</body>
</html>