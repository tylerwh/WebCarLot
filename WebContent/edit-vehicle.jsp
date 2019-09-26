<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Vehicle</title>
</head>
<body>
	<form method="post" action="EditVehicleServlet">
		Year: <input type="text" name="year" value="${vehicleToEdit.year}">
		Make: <input type="text" name="make" value="${vehicleToEdit.make}">
		Model: <input type="text" name="model" value="${vehicleToEdit.model}">
		Price: <input type="text" name="price" value="${vehicleToEdit.price}">
		<input type="hidden" name="id" value="${vehicleToEdit.id}">
		<input type="submit" value="Save Changes">
	</form>
</body>
</html>