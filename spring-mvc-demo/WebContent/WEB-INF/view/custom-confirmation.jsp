<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom confirmation form</title>
</head>
<body>
	
	The customer is confirmed: ${customer.firstName} ${customer.lastName}
	
<br>
	
	Free passes : ${customer.freePasses}

<br>

<a href="showMainForm">Main menu</a>		
</body>
</html>