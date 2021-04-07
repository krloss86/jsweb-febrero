package ar.com.eduit.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		
		if(claveBusqueda == null) {
			claveBusqueda = "";
		}
		
		ProductoService ps = new ProductoServiceImpl();
		
		try {
			Collection<Producto> productos = ps.buscarProducto(claveBusqueda);
			
			//alt+shit+m
			Stream<Producto> stream = aplicarFiltros(request, productos);
			
			productos = stream.collect(Collectors.toList());
			
			//precio total
			Float total = productos.stream().map(x->x.getPrecio()).reduce(0F, (x,y) -> x+y);
			
			request.setAttribute(ParameterEnum.LISTADO.getParam(), productos);
			
			request.setAttribute(ParameterEnum.TOTAL_LISTADO.getParam(), total );
			
		} catch (ServiceException e) {
			request.setAttribute(ParameterEnum.LISTADO.getParam(), new ArrayList<>());
			request.setAttribute(ParameterEnum.ERROR.getParam(), e.getMessage());
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(ViewEnums.LISTADO.getJsp());
		rd.forward(request, response);
	}

	private Stream<Producto> aplicarFiltros(HttpServletRequest request, Collection<Producto> productos) {
		//capturo los filtro que selecciona el usuario
		String filtroTitulo = request.getParameter(ParameterEnum.TITULO_FILTRO.getParam());
		String filtroPrecio = request.getParameter(ParameterEnum.PRECIO_FILTRO.getParam());
		String filtroTipo = request.getParameter(ParameterEnum.TIPO_PRODUCTO_FILTRO.getParam());
		
		Stream<Producto> stream = productos.stream();
		if(filtroTitulo != null && !filtroTitulo.trim().equals("")) {
			stream = stream.filter(x -> x.getTitulo().contains(filtroTitulo));
		}
		
		if(filtroPrecio != null && !filtroPrecio.trim().equals("")) {
			stream = stream.filter(x -> x.getPrecio() >= Float.parseFloat(filtroPrecio));
		}
		
		if(filtroTipo!= null && !filtroTipo.trim().equals("")) {
			stream = stream.filter(x -> x.getTipoProducto().equals(Long.parseLong(filtroTipo)));
		}
		
		return stream;
	}
}
