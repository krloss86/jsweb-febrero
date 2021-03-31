package ar.com.eduit.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.eduit.exceptions.ServiceException;
import ar.com.eduit.service.ProductoService;
import ar.com.eduit.service.impl.ProductoServiceImpl;
import ar.com.eduit.web.enums.ViewEnums;

public class ProductoServletBase extends HttpServlet {

	private static final long serialVersionUID = -6140647672199266558L;
	
	protected ProductoService ps = new ProductoServiceImpl();
	
	public String getMessage(ServiceException e) {
		String msj = e.getMessage();
		if(e.getCause() != null ) {
			msj += " - "+ e.getCause().getMessage();
		}
		return msj;
	}
	
	public void redirect(HttpServletRequest request, HttpServletResponse response, ViewEnums viewEnum) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher(viewEnum.getJsp());
		rd.forward(request, response);
	}
}
