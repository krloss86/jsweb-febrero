package ar.com.eduit.controller;

import java.util.Collection;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.exceptions.ServiceException;
import ar.com.eduit.service.ProductoService;
import ar.com.eduit.service.impl.ProductoServiceImpl;

public class ListadoProductosController {

	public static void main(String[] args) {
		
		ProductoService ps = new ProductoServiceImpl();
		
		Collection<Producto> productos;
		try {
			
			System.err.println("Consultando todos");
			productos = ps.obtenerTodos();
			System.out.println(productos);
						
			Long id = productos.iterator().next().getId();
			
			System.out.println("Consultando el id="+ id);
			Producto producto = ps.obtenerProducto(id);
			System.out.println(producto);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}

}
