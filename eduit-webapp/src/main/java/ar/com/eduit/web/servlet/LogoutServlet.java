package ar.com.eduit.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.com.eduit.web.enums.ParameterEnum;
import ar.com.eduit.web.enums.ViewEnums;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//limpiar los datos de sesion
		HttpSession session = request.getSession();
		session.removeAttribute(ParameterEnum.USER.getParam());
		
		session.invalidate();
		
		// RequestDispatcher rd = getServletContext().getRequestDispatcher(ViewEnums.LOGIN.getJsp());
		
		//rd.forward(request, response);
		
		String context = getServletContext().getContextPath();
		
		//eduit-webapp/login.jsp
		response.sendRedirect( context + ViewEnums.LOGIN.getJsp());
	}
}
