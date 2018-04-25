<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Productos</title>
</head>
<body>
	
	<table border="1">
			<tr>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Descripcion</th>
				<th>Imagen</th>
			</tr>
			

		<%-- LE PASO EL ARRAY QUE DEVUELVE EL CONTROLADOR  --%>
		<%-- HAGO UN FOREACH PARA MOSTRAR TODAS LAS FILAS QUE ME DEVUELVE LA CONSULTA  --%>
		<c:forEach items="${allProducts}" var="product">
			<tr align="center">
				<%-- LLAMO AL OBJETO EL VALOR QUE QUIERO MOSTRAR  --%>
				<td>${product[1]}</td>
				<td>${product[2]}$</td>
				<td>${product[3]}</td>
				<td><img width="200px" height="200px" src="${pageContext.request.contextPath}/img/${product[4]}"></td>	
			</tr>
		</c:forEach>
	</table>

</body>
</html>