<%@page import="ar.com.eduit.domain.User"%>
<%
	User user = (User)session.getAttribute("user");
	if(user == null) {
%>
	
	<html>
	
		<head>
			<title>Login Form</title>
		</head>
		<body>
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
					out.print("Usuario/Passoword inválido");
				}
			%>
			
			<form method="post" action="<%=request.getContextPath()%>/loginController.jsp">
				<label>Username:</label>
				<input type="text" name="username">
				
				<label>Password:</label>
				<input type="password" name="password">
				
				<input type="submit" value="Login">
			</form>
		</body>
	</html>
<%
	}else {
		response.sendRedirect(request.getContextPath()+"/loginSuccess.jsp"); //enviar a otra jsp
	}
%>