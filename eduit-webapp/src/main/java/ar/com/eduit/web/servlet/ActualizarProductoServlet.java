package ar.com.eduit.web.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.exceptions.ServiceException;
import ar.com.eduit.web.enums.ParameterEnum;
import ar.com.eduit.web.enums.ViewEnums;

@WebServlet("/ActualizarProductoServlet")
public class ActualizarProductoServlet extends ProductoServletBase {

	private static final long serialVersionUID = -3383254253978606780L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = request.getParameter(ParameterEnum.ID_PRODUCTO.getParam());
		String titulo = request.getParameter(ParameterEnum.TITULO.getParam());
		Float precio = Float.parseFloat(request.getParameter(ParameterEnum.PRECIO.getParam()));
		String codigo = request.getParameter(ParameterEnum.CODIGO.getParam());
		Long tipoProducto = Long.parseLong(request.getParameter(ParameterEnum.TIPO_PRODUCTO.getParam()));
		
		Long idL = Long.parseLong(id);
		//Float precioF = Float.parseFloat(precio);
		//Long tipoProductoL = Long.parseLong(tipoProducto);
		
		Producto producto = new Producto(idL, titulo, precio, codigo, tipoProducto);
		
		ViewEnums target = ViewEnums.LISTADO;
		try {
			this.ps.actualizarProducto(producto);
			
			request.setAttribute("exito", "Se ha actualizado el producto exitosamente");
			
			Collection<Producto> listado = this.ps.obtenerTodos();
			
			request.setAttribute("listado", listado);
		} catch (ServiceException e) {
			request.setAttribute("error", e.getCause().getMessage());
			request.setAttribute("producto", producto);
			target = ViewEnums.EDITAR;
		} 
		
		//redireccion!
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target.getJsp());
		rd.include(request, resp);
		
		//lineas codigo
	}
}
