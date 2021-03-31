<%@page import="ar.com.eduit.domain.User"%>
<%
	User user = (User)session.getAttribute("user");
	if(user == null) {
%>
<html>
	<head>
		<title>Login Form</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
	</head>
	<body>
		<div class="container">
			<!-- 
				get : lo que envío SI se ve en la url (?parametro=valor&paramatrox=valorx...)
				post: lo que envío NO se ve en la url (?parametro=valor&paramatrox=valorx...)
				
				- SE USAN EN SERVICIOS REST
				 	put
				 	delete
				 	option
				 	trace 
			-->
			<!-- get -->
			<%
				String msjError = request.getParameter("msjError");
				if(msjError != null) {
			%>
			<div class="row">
				<div class="col-12">
					<div class="alert alert-danger" role="alert">
	 						Usuario/Passoword inválido
					</div>
				</div>
			</div>
			<%
				}
			%>
			<div class="row">
				<div class="col-12">
					<form  method="post"  action="<%=request.getContextPath()%>/LoginServlet">
					  <div class="form-group">
					    <label for="exampleInputEmail1">Email address</label>
					    <input type="text" name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
					    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">Password</label>
					    <input name="password" type="password" class="form-control" id="exampleInputPassword1">
					  </div>				  
					  <button type="submit" class="btn btn-primary">Login</button>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
<%
	}else {
		response.sendRedirect(request.getContextPath()+"/loginSuccess.jsp"); //enviar a otra jsp
	}
%>