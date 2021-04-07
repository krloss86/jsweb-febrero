package ar.com.eduit.parsers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ar.com.eduit.domain.Producto;

/**
 * java 7/8
 * @author CHLopez
 *
 */
public class TextoFileParser implements IFileParser<List<String>> {

	private Collection<Producto> productos;
		
	@Override
	public List<String> parse() throws IOException {
			
		List<String> productosString = new ArrayList<String>();
		
		productosString.add("id;titulo;precio;codigo;tipo_producto\n");
		
		//titulo
		for(Producto producto : this.productos ) {
			productosString.add(getStringFromProducto(producto));
		}
		
		//producto
		return productosString;
	}
	
	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}

	public List<String> parse(Collection<Producto> productos) {
		
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
	}
}
