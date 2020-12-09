<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="navigation-bar2.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/pet_home-style.css">
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
<title>My Pets</title>
</head>
<body>
    <header>
      <h1>My Pets</h1>
    </header>
	<c:if test="${myPets==null}">
		<p id="Message">${message}</p>
	</c:if>
	
	<c:if test="${myPets!=null}">
		<div id="container">

			<table border="1"
				class="table table-bordered table-striped table-hover">
				<tr>
					<th>Pet Name</th>
					<th>Pet Age</th>
					<th>Pet Place</th>
				</tr>

				<c:forEach items="${myPets}" var="element">
					<tr>
						<td>${element.name}</td>
						<td>${element.age}</td>
						<td>${element.place}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>


</body>
</html>