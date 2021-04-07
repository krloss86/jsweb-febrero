package ar.com.eduit.web.servlet.clase13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.exceptions.ServiceException;
import ar.com.eduit.service.ProductoService;
import ar.com.eduit.service.impl.ProductoServiceImpl;

public class StreamMainFilter5 {

	public static void main(String[] args) throws ServiceException {
		
		ProductoService ps = new ProductoServiceImpl();
		
		Collection<Producto> productos = ps.obtenerTodos();
		
		//existe el producto con codigo 000010
		
		Optional<Producto> exiteCodigo000010 = productos
			.stream()
			.filter(x-> x.getCodigo().equals("000010"))
			.findFirst();
		
		if(exiteCodigo000010.isPresent()) {
			Producto p = exiteCodigo000010.get();
			System.out.println(p);
		}else {
			System.err.println("No existe 000010");
		}
	}

}
