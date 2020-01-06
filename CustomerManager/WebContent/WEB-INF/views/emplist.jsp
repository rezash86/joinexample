<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table>
			<tr>
				<th>emp name</th>
				<th>department name</th>
			</tr>
			
			<c:forEach  items="${lstEmployee}" var="emp">
				<tr>
					<td>${emp[0].empName}</td>
					<td>${emp[1].name}</td>
				</tr>
			</c:forEach>
			    
		</table>
	</div>
</body>
</html>