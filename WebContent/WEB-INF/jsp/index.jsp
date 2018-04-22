<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Welcome to Home</title>
		<link href='<c:url value="/css/style.css"></c:url>' rel="stylesheet">
	
		<script type="text/javascript" src='<c:url value="/js/demo.js"></c:url>'></script>

	
	
</head>
<body>

	<h1>Ingresar Usuario</h1>
	
<!-- 	AUTHENTICATION PROCES FOR LOGIN SECCION 6 -->
	<label style="color: red;">${error_msg}</label>
	
	<form:form action="${pageContext.request.contextPath}/index" modelAttribute="user" method="post">
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

	<script>
	    function popup() {
	        window.open("${pageContext.request.contextPath}/login", 'window', 'width=720,height=720');
	    }
	</script>

	<a onclick="popup()">LOGUEARSE</a>
	<a class="demo" href="${pageContext.request.contextPath}/login">Login</a>	
	<a class="demo" href="${pageContext.request.contextPath}/signup">Sign Up</a>
	<a onclick="hello()">Sign Up</a>
	
	
	<table border="1" id="productTable">
			<tr>
				<th>Tipo</th>
				<th>Marca</th>
				<th>Talla</th>
				<th>Peso</th>
				<th>Altura</th>
				<th>Imagen</th>
				<th>Eliminar</th>
			</tr>
			

		<%-- LE PASO EL OBJETO QUE ME DEVUELVE EL CONTROLADOR  --%>
		<%-- HAGO UN FOREACH PARA MOSTRAR TODAS LAS FILAS QUE ME DEVUELVE LA CONSULTA  --%>
		<c:forEach items="${allProducts}" var="product">
		<%-- PARA SABER QUE PRODUCTO/FILA ELIMINO  --%>
			<tr  id="tr_${product.id_rev}" align="center">
				<%-- LLAMO AL OBJETO EL VALOR QUE QUIERO MOSTRAR  --%>
				<td>${product.categoria}</td>
				<td>${product.marca}</td>
				<td>${product.talla}</td>
				<td>${product.peso}</td>
				<td>${product.altura}</td>
				<td><img width="200px" height="200px" src="${pageContext.request.contextPath}/img/${product.imagen}"></td>	
<%-- 				<td><input type="button" value="Delete" id="btn_${product.id_rev}" onclick="deleteProduct(this.id_rev)"></td> --%>
			</tr>
		</c:forEach>
	</table>
	
	
	
	
	
	
</body>
</html>