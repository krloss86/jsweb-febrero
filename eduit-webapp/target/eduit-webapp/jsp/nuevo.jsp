<%@page import="ar.com.eduit.web.enums.ParameterEnum"%>
<html>
	<head>
		<!-- boostrap -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	</head>
	<body>
		<%@include file="navbar.jsp" %>
		<div class="container-fluid">
			
			<% if(request.getAttribute(ParameterEnum.ERROR.getParam()) != null) {%>
				<div class="row">
					<div class="col-12">
						<div class="alert alert-danger" role="alert">
						  <%=request.getAttribute(ParameterEnum.ERROR.getParam())%>
						</div>
					</div>
				</div>
			<% }%>
			
			<div class="row">
			
				<div class="col-md-12 col-md-8 col-lg-9 col-xl-6">
					<form action="<%=request.getContextPath() %>/NuevoProductoServlet" method="post">
					  
					  <div class="form-group">
					    <label for="codigo">C�digo</label>
					    <input name="codigo" type="text" class="form-control" id="codigo">
					  </div>
					  
					  <div class="form-group">
					    <label for="titulo">Titulo</label>
					    <input name="titulo" type="text" class="form-control" id="titulo">
					  </div>
					  
					  <div class="form-group">
					    <label for="precio">Precio</label>
					    <input name="precio" type="text" class="form-control" id="precio">
					  </div>
					  
					  <div class="form-group">
					    <label for="tipoProducto">Tipo Producto</label>
					    <select name="tipoProducto" class="form-control" id="tipoProducto">
					      <option value="1">Herramientas</option>
					      <option value="2">Electrodomesticos</option>
					      <option value="2">Celulares</option>
					      <option value="2">Cocina</option>
					    </select>
					  </div>
					  
					  <button type="submit" class="btn btn-primary">Grabar</button>
					</form>
				</div>
				
			</div>	
		</div>
	</body>
</html>