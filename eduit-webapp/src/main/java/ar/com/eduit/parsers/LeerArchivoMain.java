package ar.com.eduit.parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivoMain {

	public static void main(String[] args) {
		
		//ctrl+shit+i
		String path = "c:/data/productos.csv";
		
		//File 
		File nuevosProductos = new File(path);
		
		boolean existe = nuevosProductos.exists();
		
		if(existe) {
			// abrir
			boolean isFile = nuevosProductos.isFile();
			
			if (isFile) {
				
				try {
					FileReader fileReader = new FileReader(nuevosProductos);
					
					int unCaractarer;
					
					//leer 
					while((unCaractarer = fileReader.read()) !=-1) {
						//mientras existan datos
						
						System.out.print((char)unCaractarer);
					}		
					
					fileReader.close();
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
