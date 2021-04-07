package ar.com.eduit.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.com.eduit.domain.User;
import ar.com.eduit.exceptions.ServiceException;
import ar.com.eduit.service.UserService;
import ar.com.eduit.service.impl.UserServiceImpl;
import ar.com.eduit.web.enums.ParameterEnum;
import ar.com.eduit.web.enums.ViewEnums;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//OBTENER LOS DATOS ENVIADOS POR LA JSP
		String username= request.getParameter(ParameterEnum.USERNAME.getParam());
		String password= request.getParameter(ParameterEnum.PASSWORD.getParam());
		
		UserService us = new UserServiceImpl();
		
		ViewEnums target = ViewEnums.LOGIN_SUCCESS;
		
		try {
			User user =  us.obtenerUsuario(username);
			
			if(user != null && user.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute(ParameterEnum.USER.getParam(), user);
			}
		} catch (ServiceException e) {
			target = ViewEnums.LOGIN;
			request.setAttribute("mensajeError", "Usuario/Password Inválido");
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target.getJsp());
		rd.forward(request, response);
	}

}
