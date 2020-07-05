<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fitness Tracker Custom Login Page</title>

<style type="text/css">
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #FF0000;
	padding: 8px;
	margin: 16px;
}
</style>

</head>
<body onload='document.f.j_username.focus();'>
	<h3>Fitness Tracker Custom Login Page</h3>
	<c:if test="${not empty error}">
		<div class="errorblock">
			your login was unsucsessfull.<br/>
		 	caused : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
		</div>
	</c:if>
	
	<form action="j_spring_security_check" name="f" method="post">
		<table>
			<tr>
				<td>User: </td>
				<td><input type="text" name="j_username" value=""></td>
			</tr>
			<tr>
				<td>password: </td>
				<td><input type="password" name="j_password" value=""></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="Submit" value="Submit">
				</td>
			</tr>		
			<tr>
				<td colspan="2">
					<input type="reset" name="reset" value="Reset">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>