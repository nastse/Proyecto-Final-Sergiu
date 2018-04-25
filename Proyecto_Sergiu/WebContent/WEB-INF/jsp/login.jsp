<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login Page</title>
	
	<script>
	 	function closeWindow() {
	        window.close();
	    }
	</script>
	
</head>
<body>
	
	<h1>Ingresar Usuario</h1>
	
<!-- 	AUTHENTICATION PROCES FOR LOGIN SECCION 6 -->
	<label style="color: red;">${error_msg}</label>
	
	<form:form action="${pageContext.request.contextPath}/login" modelAttribute="user" method="post" onsubmit="closeWindow()">
		<form:errors path="*" style="color:red; background-color:#ffb3b3;" element="div"/>
		<table>
			<tr>
				<td><label>Enter Username:</label></td>
				<td>
					<form:input type="text" path="email" name="username"></form:input></td>
<%-- 					<br><form:errors path="email" style="color:red"></form:errors> --%>
				
			</tr>
			<tr>
				<td><label>Enter Password:</label></td>
				<td>
					<form:input type="password" path="password" name="password"></form:input></td>
<%-- 					<br><form:errors path="password" style="color:red"></form:errors> --%>
				
			</tr>
			<tr>
				<td>&nbsp</td>
				<td align="center"><input type="submit" name="Login"></td>
			</tr>
			
			
		</table>
	
	</form:form>
	
</body>
</html>