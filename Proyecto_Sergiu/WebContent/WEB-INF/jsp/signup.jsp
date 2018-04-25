<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Here</title>

	<script type="text/javascript">
		
		function dovalidations(){
			
			var username = document.getElementById("email").value;
			var password = document.getElementById("password").value;
			var repassword = document.getElementById("repassword").value;
			
			if(parseInt(email.length) < 4){
				
				alert("El nombre debe tener mas de 3 caracteres");
				return false;
			}
			
			if(parseInt(password.length) < 6){
				
				alert("La contraseña debe tener mas de 5 caracteres");
				return false;
			}
			
			if(password != repassword){
				
				alert("La contraseña no coincide");
				return false;
			}

			return true;
		}
	
	</script>

</head>
<body>

	<label style="color: red;">${error_msg}</label>

<!-- 	SERVER SIDE VALIDATION USING SPRING SECCION 7 -->
	<form:form action="${pageContext.request.contextPath}/signup" modelAttribute="user" method="post">
		<form:errors path="*" style="color:red; background-color:#ffb3b3;" element="div"/>
		<table>
			<tr>
				<td><label>Email:</label></td>
				<td><form:input id="email" type="text" path="email" name="email"></form:input></td>
			</tr>
			<tr>
				<td><label>Contraseña:</label></td>
				<td><form:input id="password" type="password" path="password" name="password"></form:input></td>
			</tr>
			<tr>
				<td><label>Confirma Contraseña:</label></td>
				<td><input id="repassword" type="password" name="repassword"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Registrarse"></td>
			</tr>
		</table>
	
	</form:form>
</body>
</html>