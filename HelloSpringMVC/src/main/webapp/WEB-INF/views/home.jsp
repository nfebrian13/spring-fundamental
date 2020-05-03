<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page session="false" %> 
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
		<h1>Hello World!</h1>
		<p>The time on the server is ${serverTime} </p>
		<p><a href=${pageContext.request.contextPath}/download>Click here to download file</a></p>
		<p><a href=${pageContext.request.contextPath}/downloadCSV>Download CSV #1</a></p>
        <p><a href=${pageContext.request.contextPath}/viewCSV>Download CSV #2</a></p>
</body>
</html>