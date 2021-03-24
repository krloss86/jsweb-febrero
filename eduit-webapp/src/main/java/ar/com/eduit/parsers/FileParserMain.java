package ar.com.eduit.parsers;

import java.io.IOException;
import java.util.Collection;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.exceptions.ServiceException;
import ar.com.eduit.service.ProductoService;
import ar.com.eduit.service.impl.ProductoServiceImpl;

public class FileParserMain {

	private static ProductoService ps = new ProductoServiceImpl();
	
	public static void main(String[] args) throws IOException, ServiceException {

		//html, jsp, servicio. etc
		String path = "c:/data/productos.csv";
		
		IFileParser csvFileParser = new CSVFileParser(path);

		Collection<Producto> productos = (Collection<Producto>)csvFileParser.parse();
		
		for(Producto producto : productos) {
			
			ps.crearProducto(producto);
		}
	}

}
