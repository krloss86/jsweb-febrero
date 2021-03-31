package ar.com.eduit.web.servlet;

import java.io.IOException;
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

@WebServlet("/NuevoProductoServlet")
public class NuevoProductoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ViewEnums target = ViewEnums.LISTADO;
		try {
			String titulo = request.getParameter(ParameterEnum.TITULO.getParam());
			Float precio = Float.parseFloat(request.getParameter(ParameterEnum.PRECIO.getParam()));
			String codigo = request.getParameter(ParameterEnum.CODIGO.getParam());
			Long tipoProducto = Long.parseLong(request.getParameter(ParameterEnum.TIPO_PRODUCTO.getParam()));
			
			//aplicar validaciones!!!
			
			Producto nuevoProducto = new Producto(titulo, precio, codigo, tipoProducto);
			
			ProductoService ps = new ProductoServiceImpl();
			
			nuevoProducto = ps.crearProducto(nuevoProducto);
			
			//recargo la lista de productos a pesentar en listado
			Collection<Producto> productos = ps.obtenerTodos();
			request.setAttribute(ParameterEnum.LISTADO.getParam(), productos);
			
			request.setAttribute(ParameterEnum.EXITO.getParam(), "Alta de producto id:" + nuevoProducto.getId() + " exitoso" );
		} catch (NumberFormatException | ServiceException e) {
			target = ViewEnums.NUEVO;
			request.setAttribute(ParameterEnum.ERROR.getParam(), e.getMessage() + " - " + e.getCause().getMessage());
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target.getJsp());
		rd.forward(request, response);
	}
}
