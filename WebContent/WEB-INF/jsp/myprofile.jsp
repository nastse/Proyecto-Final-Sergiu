<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mi Perfil</title>
</head>
<body>

	<h2>Howdy,${email}</h2>
	
	<hr>
	
	<h4>Lista,${listaReviews}</h4>
	<table border="1" id="productTable">
			<tr>
				<th>Tipo</th>
				<th>Marca</th>
				<th>Talla</th>
				<th>Peso</th>
				<th>Altura</th>
				<th>Imagen</th>
				<th>Eliminar</th>
				<th>Actualizar</th>
			</tr>
			

		<%-- LE PASO EL OBJETO QUE ME DEVUELVE EL CONTROLADOR  --%>
		<%-- HAGO UN FOREACH PARA MOSTRAR TODAS LAS FILAS QUE ME DEVUELVE LA CONSULTA  --%>
		<c:forEach items="${listaReviews}" var="product">
		<%-- PARA SABER QUE PRODUCTO/FILA ELIMINO  --%>
			<tr  id="tr_${product.id_rev}" align="center">
				<td>${product.categoria}</td>
				<td>${product.marca}</td>
				<td>${product.talla}</td>
				<td>${product.peso}</td>
				<td>${product.altura}</td>
				<td><img width="200px" height="200px" src="${pageContext.request.contextPath}/img/${product.imagen}"></td>	
				<td><input type="button" value="Delete" id="btn_${product.id_rev}"></td>
				<td><a href="<c:url  value='/vista/${product.id_rev}'/>">Editar</a></td>
			</tr>
		</c:forEach>
	</table>
	
	
	<a href="${pageContext.request.contextPath}/products">Lista productos</a>
	
	
</body>
</html>