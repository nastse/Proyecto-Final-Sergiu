<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Here</title>

	<script type="text/javascript">
		
		function dovalidations(){
			
			var username = document.getElementById("username").value;
			var password = document.getElementById("password").value;
			var repassword = document.getElementById("repassword").value;
			
			if(parseInt(username.length) < 4){
				
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

	<form action="${pageContext.request.contextPath}/signup" method="post" enctype="multipart/form-data" onsubmit="return dovalidations()">
		<table>
			<tr>
				<td><label>Nombre de Usuario:</label></td>
				<td><input id="username" type="text" name="username"></td>
			</tr>
			<tr>
				<td><label>Contraseña:</label></td>
				<td><input id="password" type="password" name="password"></td>
			</tr>
			<tr>
				<td><label>Confirma Contraseña:</label></td>
				<td><input id="repassword" type="password" name="repassword"></td>
			</tr>
			<tr>
				<td><label>Género:</label></td>
				<td><input type="radio" name="sexo" value="Hombre"><input type="radio" name="sexo" value="Mujer"></td>
			</tr>
			<tr>
				<td><label>Vehículo:</label></td>
				<td><input type="checkbox" name="vehiculo" value="Coche"><input type="checkbox" name="vehiculo" value="Bici"></td>
			</tr>
			<tr>
				<td><label>País:</label></td>
				<td>
					<select name="pais">
						<option value="spain">SPAIN</option>
						<option value="portugal">PORTUGAL</option>
						<option value="usa" selected="selected">USA</option>				
					</select>
				</td></tr>
			<tr>
				<td><label>Selecciona una imagen:</label></td>
				<td><input type="file" name="image"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Registrarse"></td>
			</tr>
		</table>
	
	</form>
</body>
</html>