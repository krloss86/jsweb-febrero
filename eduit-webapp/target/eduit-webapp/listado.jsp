<%@page import="ar.com.eduit.domain.Producto"%>
<%@page import="java.util.Collection"%>
<%@page import="ar.com.eduit.service.impl.ProductoServiceImpl"%>
<%@page import="ar.com.eduit.service.ProductoService"%>
<%
	ProductoService ps = new ProductoServiceImpl();
	Collection<Producto> productos = ps.obtenerTodos();
%>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<a href="<%=request.getContextPath()%>/LogoutServlet" 
				class="btn btn-primary btn-lg active" 
				role="button" 
				aria-pressed="true">
					Logout
			</a>
		</div>
		<div class="row">
			<div class="col-sm-12 col-md-9 col-lg-6 col-xl-4">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">First</th>
							<th scope="col">Last</th>
							<th scope="col">Handle</th>
						</tr>
					</thead>
					<tbody>
					<%
						for(Producto p : productos) {
					%>
						<tr>
							<th scope="row"><%=p.getId() %></th>
							<td><%=p.getTitulo() %></td>
							<td><%=p.getPrecio() %></td>
							<td><%=p.getTipoProducto() %></td>
						</tr>						
					<%
						}
					%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>