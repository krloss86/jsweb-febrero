package ar.com.eduit.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.eduit.domain.Producto;

public class LeerArchivoBufferMain {

	public static void main(String[] args) {
		
		//ctrl+shit+i
		String path = "c:/data/productos.csv";
		
		//File 
		File nuevosProductos = new File(path);
		
		boolean existe = nuevosProductos.exists();
		
		Collection<Producto> productos = new ArrayList<Producto>();
		
		if(existe) {
			// abrir
			boolean isFile = nuevosProductos.isFile();
			
			if (isFile) {
				
				try {
					FileReader fileReader = new FileReader(nuevosProductos);
					BufferedReader bufferReader = new BufferedReader(fileReader);
						
					//descarto la primer linea,
					String unaLinea = bufferReader.readLine();
					System.out.println(unaLinea);
					
					//leer 
					while((unaLinea = bufferReader.readLine()) != null) {
						String[] datos = unaLinea.split(";");
						String titulo =  datos[0];
						String precio = datos[1];
						String codigo = datos[2];
						String tipoProducto = datos[3];
						
						//mientras existan datos
						Producto producto = new Producto(titulo, Float.parseFloat(precio), codigo, Long.parseLong(tipoProducto));
						productos.add(producto);
					}		
					
					fileReader.close();
					
					//informar la lista de productos parseados del archivo
					for(Producto aux : productos) {
						System.out.println(aux);
					}
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
				}			
			}else {
				System.err.println(path + " No es un archivo conocido!!!");
			}
		}else {
			System.err.println(path + " No existe");
		}

	}

}
