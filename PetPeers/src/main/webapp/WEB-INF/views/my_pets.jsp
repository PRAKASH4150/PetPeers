<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Pets</title>
</head>
<body>
	<table border="1">
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
</body>
</html>