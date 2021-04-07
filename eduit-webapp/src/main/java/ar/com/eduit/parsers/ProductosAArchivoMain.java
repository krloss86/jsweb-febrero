package ar.com.eduit.parsers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class ProductosAArchivoMain {

	public static void main(String[] args) {
		
		StringBuffer productos = new StringBuffer("titulo;precio;codigo;tipo_producto").append("\n");
		productos.append("carpeta n3;250;car001;5").append("\n");
		productos.append("pen driver;250;car002;6");
		
		String outputPath = "c:" + File.separator + "data" + File.separator + "nuevosproductos.txt";
		
		//file
		File nuevoFile = new File(outputPath);
		
		//filewritter
		try {
			FileWriter fileWritter = new FileWriter(nuevoFile);
			
			fileWritter.write(productos.toString());
			
			fileWritter.close();
		} catch (IOException e) {		
			e.printStackTrace();
		}

		File f = new File(outputPath);
		
		System.out.println(f.exists());
	}

}
