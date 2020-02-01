<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation Form</title>
</head>
<body>
	Student: ${student.firstName} ${student.lastName}
	<br/>
	<br/>
	Student.country: ${student.country}
	<br/>
	Student.favoritLanguage: ${student.favoriteLanguage}
	<br/>
	Operating System:
	<ul>
		<c:forEach var="temp" items="${student.operatingSystem}" >
		<li>${temp}</li>
		</c:forEach>
	</ul>
	
<br>
<a href="showMainForm">Main menu</a>		
</body>
</html>