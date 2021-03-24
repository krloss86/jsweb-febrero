package ar.com.eduit.parsers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ar.com.eduit.domain.Producto;

public interface IFileParser<T> {

	public T parse() throws IOException;
	/*
	public default List<String> parse(Collection<Producto> productos) {
		
		List<String> productosString = new ArrayList<String>();
		
		productosString.add("id;titulo;precio;codigo;tipo_producto\n");
		
		//titulo
		for(Producto producto : productos ) {
			productosString.add(getStringFromProducto(producto));
		}
		
		//producto
		return productosString;
	}
	
	private String getStringFromProducto(Producto p) {
		StringBuffer productoString = new StringBuffer();
		productoString.append(p.getId()).append(";");
		productoString.append(p.getTitulo()).append(";");
		productoString.append(p.getPrecio()).append(";");
		productoString.append(p.getCodigo()).append(";");
		productoString.append(p.getTipoProducto());
		productoString.append("\n");
		return productoString.toString();
	}*/
}
