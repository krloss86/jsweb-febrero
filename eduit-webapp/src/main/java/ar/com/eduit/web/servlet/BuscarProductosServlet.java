package ar.com.eduit.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.exceptions.ServiceException;
import ar.com.eduit.service.ProductoService;
import ar.com.eduit.service.impl.ProductoServiceImpl;
import ar.com.eduit.web.enums.ParameterEnum;
import ar.com.eduit.web.enums.ViewEnums;

@WebServlet("/BuscarProductosServlet")
public class BuscarProductosServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String claveBusqueda = request.getParameter(ParameterEnum.CLAVE_BUSQUEDA.getParam());
		
		ProductoService ps = new ProductoServiceImpl();
		
		try {
			Collection<Producto> productos = ps.buscarProducto(claveBusqueda);
			request.setAttribute(ParameterEnum.LISTADO.getParam(), productos);
			
		} catch (ServiceException e) {
			request.setAttribute(ParameterEnum.LISTADO.getParam(), new ArrayList<>());
			request.setAttribute(ParameterEnum.ERROR.getParam(), e.getMessage());
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(ViewEnums.LISTADO.getJsp());
		rd.forward(request, response);
	}
}
