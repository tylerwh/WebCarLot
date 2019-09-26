<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lot View</title>
</head>
<body>
	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.inventory}" var="currentVehicle">
				<tr>
					<td><input type="radio" name="id" value="${currentVehicle.id}"></td>
					<td>${currentVehicle.year}</td>
					<td>${currentVehicle.make}</td>
					<td>${currentVehicle.model}</td>
					<td>${currentVehicle.price}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Add" name="vehicleProcess">
		<input type="submit" value="Edit" name="vehicleProcess">
		<input type="submit" value="Delete" name="vehicleProcess">
	</form>
</body>
</html>