package ar.com.eduit.parsers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.exceptions.ServiceException;
import ar.com.eduit.service.ProductoService;
import ar.com.eduit.service.impl.ProductoServiceImpl;

public class MainListadoProductos {

	public static void main(String[] args) throws ServiceException, IOException {
		
		ProductoService ps = new ProductoServiceImpl();
		
		Collection<Producto> productos = ps.obtenerTodos();
		
		TextoFileParser fileParser = new TextoFileParser();
		
		fileParser.setProductos(productos);
		
		List<String> lineas = (List<String>)fileParser.parse();
		
		String outputPath = "c:/data/ext/";
		String fileName = "lineas.csv";
		File outputFile = new File(outputPath);
		
		if(!outputFile.exists()) {
			//crear la carpeta			
			Files.createDirectories(outputFile.toPath());
			
		}
		outputFile = new File(outputPath + fileName);
		
		FileWriter fr = new FileWriter(outputFile);
		
		for(String linea : lineas) {
			fr.write(linea);
		}
		
		fr.close();
	}

}
