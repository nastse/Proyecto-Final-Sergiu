<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Productos</title>

	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

	<script type="text/javascript">
		<%-- FUNCION QUE ELIMINA UN PRODUCTO/FILA AL HACER CLICK EN EL BOTON --%>
		function deleteProduct(id){
			id = id.split("_")[1];
			
			$.ajax({
				
		// LA PAGINA A LA QUE LLAMO PARA BORRAR UN PRODUCTO
				url : "${pageContext.request.contextPath}/deleteProduct",
				type : "post",
				data : "productId="+id,
				
				success : function(response){
					var table = document.getElementById("productTable");
					var tr = document.getElementById("tr_"+id);
					table.deleteRow(tr.rowIndex);
					alert(response);
				},
				
				error :function(error){
					alert(error);
				}
				
			});
			
		}
	</script>
	


</head>
<body>
	
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
				<td><input type="button" value="Delete" id="btn_${product.id_rev}" onclick="deleteProduct(this.id)"></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>