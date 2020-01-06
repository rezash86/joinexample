<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>save employee</title>
</head>
<body>
	<div align="center">
		<h2>save Employee</h2>
		<form:form action="save_emp" method="post" modelAttribute="employee">

			<table border="0" cellpadding="5">
				<tr>
				</tr>			
				<tr>
					<td>Name: </td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Address: </td>
					<td><form:input path="address.streetName" /></td>
				</tr>		
				<tr>
					<td colspan="2"><input type="submit" value="Save me"></td>
				</tr>						
			</table>


		</form:form>
</body>
</html>