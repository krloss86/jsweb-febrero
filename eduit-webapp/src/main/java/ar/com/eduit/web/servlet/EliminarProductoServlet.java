package ar.com.eduit.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.exceptions.ServiceException;
import ar.com.eduit.web.enums.ParameterEnum;
import ar.com.eduit.web.enums.ViewEnums;

@WebServlet("/EliminarProductoServlet")
public class EliminarProductoServlet extends ProductoServletBase {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter(ParameterEnum.ID_PRODUCTO.getParam());
		
		//opcional!!
		if(id == null || id.trim().isEmpty()) {
			response.sendRedirect(getServletContext().getContextPath() + ViewEnums.LISTADO);
		}
		
		Long idProducto = Long.parseLong(id);
		
		try {
			ps.eliminarProducto(idProducto);
			
			request.setAttribute(ParameterEnum.EXITO.getParam(), "Se ha eliminado el producto id:" + id);			
		} catch (ServiceException e) {
			request.setAttribute(ParameterEnum.ERROR.getParam(), getMessage(e)) ;
		}
		
		//recargo la lista de productos a pesentar en listado
		Collection<Producto> productos;
		try {
			productos = ps.obtenerTodos();
			request.setAttribute(ParameterEnum.LISTADO.getParam(), productos);
		} catch (ServiceException e) {
			request.setAttribute(ParameterEnum.ERROR.getParam(), getMessage(e)) ;
			request.setAttribute(ParameterEnum.LISTADO.getParam(), new ArrayList<>());
		}
		
		redirect(request, response, ViewEnums.LISTADO);
	}
}
