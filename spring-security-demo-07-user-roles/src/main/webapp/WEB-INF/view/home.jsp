<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h2>Home Page</h2>
	<hr>
	<p>
	Welcome to the home page!
	</p>
	<hr>
	
	<!-- display user name and roles -->
	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities"/>
		
	</p>
	<hr>
	<!--  And a link  to point to/leader . . .  this is for manager -->
	<p>
		<a href="${pageContext.request.contextPath}/leaders">LeaderShipMeeting</a>
		(Only for Manager peeps)
	</p>
	<hr>
	<!--  And a link  to point to/system . . .  this is for manager -->
	<p>
		<a href="${pageContext.request.contextPath}/systems">AdminShipMeeting</a>
		(Only for Administrators peeps)
	</p>
	<hr>
	
	<!-- Add logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />
	</form:form>
	

</body>
</html>