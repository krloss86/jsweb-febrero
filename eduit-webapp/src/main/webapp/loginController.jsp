<%@page import="ar.com.eduit.domain.User"%>
<%@page import="ar.com.eduit.service.impl.UserServiceImpl"%>
<%@page import="ar.com.eduit.service.UserService"%>

<%	
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	UserService userService = new UserServiceImpl();
	
	User user = userService.obtenerUsuario(username);
	
	if(user != null && user.getPassword().equals(password)) {
		//guardar en sesion el usuario
		session.setAttribute("user", user);//guardar un objeto completo en la sesion
		
		response.sendRedirect(request.getContextPath()+"/loginSuccess.jsp"); //enviar a otra jsp
	}else {
		response.sendRedirect(request.getContextPath()+"/login.jsp?msjError=error");
	}
%>