<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/css/select2.min.css" />

</head>
<body>

   <h1>Select2.js Example</h1>
   <form action="MyServlet" method="post">
      <select id="mySelect" name="mySelect[]" multiple>
         <option value="option1">Option 1</option>
         <option value="option2">Option 2</option>
         <option value="option3">Option 3</option>
      </select>
      <button type="submit">Submit</button>
   </form>
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"></script>
   <script>
      $(document).ready(function() {
         $('#mySelect').select2();
      });
   </script>
</body>
</html>
