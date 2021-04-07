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

@WebServlet("/CargarParaEditarProductoServlet")
public class CargarParaEditarProductoServlet extends ProductoServletBase {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter(ParameterEnum.ID_PRODUCTO.getParam());
		
		//opcional!!
		if(id == null || id.trim().isEmpty()) {
			response.sendRedirect(getServletContext().getContextPath() + ViewEnums.LISTADO);
		}
		
		Long idProducto = Long.parseLong(id);
		
		ViewEnums target = ViewEnums.EDITAR;
		try {
			Producto producto = ps.obtenerProducto(idProducto);
			
			if(producto != null) {
				request.setAttribute(ParameterEnum.PRODUCTO.getParam(), producto);
			}else {
				throw new ServiceException("NO existe el producto id:" + idProducto, null);
			}
		} catch (ServiceException e) {
			target = ViewEnums.LISTADO;
			
			request.setAttribute(ParameterEnum.ERROR.getParam(), getMessage(e));
			
			//recargo el listado de productos porque vuelvo al listado.jsp
			//recargo la lista de productos a pesentar en listado
			Collection<Producto> productos;
			try {
				productos = ps.obtenerTodos();
				request.setAttribute(ParameterEnum.LISTADO.getParam(), productos);
			} catch (ServiceException e1) {
				request.setAttribute(ParameterEnum.ERROR.getParam(), getMessage(e1));
				request.setAttribute(ParameterEnum.PRODUCTO.getParam(), new ArrayList<>());	
			}
		}
		
		redirect(request, response, target);
	}
}
