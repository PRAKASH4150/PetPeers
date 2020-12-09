<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="navigation-bar2.jsp" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Pets</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/pet_form-style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/scripts/pet_form.js"></script> 
</head>
<body>
    <header>
     <h1>Add Pet</h1>
    </header>
    <p id="error">${error}</p>
  <div id="container">
		<form:form action="addPet" method="post" modelAttribute="petDetails">

			<label for="petname" class="field">Name<span class="mandatory">*</span></label>
			<br>
			<form:input path="name" class="value" name="petname" id="petname"
				placeholder="Enter the Pet name" />
	        <br>
	        
			<label for="petage" class="field">Age<span class="mandatory">*</span></label>
			<br>
			<form:input path="age" class="value" name="petage" id="petage"
				placeholder="Enter the Pet Age" />
            <br>
            
			<label for="petplace" class="field">Place<span class="mandatory">*</span></label>
			<br>
			<form:input path="place" class="value" name="petplace"
				id="petplace" placeholder="Enter the Pet Place" />
            <br>
            
			<input type="submit" id="button1" name="add"
				class="btn btn-success" value="Save" onclick="return validateForm()">
			<input type="reset" id="button2" class="btn btn-success" Value="Cancel">
		</form:form>
	</div>
</body>
</html>