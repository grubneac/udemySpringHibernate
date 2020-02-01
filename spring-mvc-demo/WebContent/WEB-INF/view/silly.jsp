<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sylly </title>
</head>
<body>
<h4>Sylly Form</h4>
<br>
	<form action="processForm" method="get">
		<input type="text" name="studentName" placeholder="What`s your name?"/>
		<input type="submit" />
	</form>
	<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
	<c:choose>
	    <c:when test="${param.studentName !=null}">
	        Student Name  "${param.studentName}
	        <br />
	        The message:  ${message}
	    </c:when>    
	    <c:otherwise>
	         
	        <br />
	        
	    </c:otherwise>
	</c:choose>	


<br>
<a href="showMainForm">Main menu</a>	
</body>
</html>