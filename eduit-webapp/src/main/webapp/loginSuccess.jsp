<%@page import="ar.com.eduit.domain.User"%>
<%
	User user = (User)session.getAttribute("user");
	if(user != null) {
%>
	<html>
	
		<header>
			<title>Login Success</title>
		</header>
		
		<body>
			Bienvenido:  <%=user.getUsername()%>
			
			<a href="<%=request.getContextPath()%>/listado.jsp">Listado Productos</a>			
		</body>
	</html>
<%
	}else {
		//no puede accedera esta jsp
		response.sendRedirect(request.getContextPath()+"/login.jsp?msjError=Sin sesion");
	}
%>