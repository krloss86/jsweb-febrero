package ar.com.eduit.web.servlet.clase13;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.exceptions.ServiceException;
import ar.com.eduit.service.ProductoService;
import ar.com.eduit.service.impl.ProductoServiceImpl;

public class StreamMainFilter6 {

	public static void main(String[] args) throws ServiceException {
		
		ProductoService ps = new ProductoServiceImpl();
		
		Collection<Producto> productos = ps.obtenerTodos();
		
		//los productos con precio > 1500
		
		List<Producto> mayores1500 = productos
				.stream()
				.filter(x -> x.getPrecio() > 1500) //operacion intermedia				
				.collect(Collectors.toList()); //operacion terminal
		
		System.out.println(mayores1500);
		
		Float sumaPrecios = productos
			.stream()
			.map(x->x.getPrecio())//intermedia que cambia de Producto a Float
			.reduce(0F, (x, y) -> x+ y);
			
		System.out.println(sumaPrecios);
		
		Set<String> codigos = productos
			.stream()
			.map(x-> x.getCodigo())
			.collect(Collectors.toSet());
		
		System.out.println(codigos);
	}

}
