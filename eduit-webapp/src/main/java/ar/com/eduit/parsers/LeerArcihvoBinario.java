package ar.com.eduit.parsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LeerArcihvoBinario {

	public static void main(String[] args) throws IOException {
		
		File sourceFile = new File("c:/data/project-header.png");
		
		File outputFile = new File("c:/data/ext/project-header.png");

		//4096 byte
		InputStream entrada = new FileInputStream(sourceFile);
		OutputStream salida = new FileOutputStream(outputFile);
		
		//acá guardo los bytes parciales!
		byte[] buffer = new byte[1024];
		
		//leo la primera
		int length = entrada.read(buffer);
		
		while( length > 0) {
			salida.write(buffer,0, length);
			
			//leo las demas
			length = entrada.read(buffer);
		}
		
		entrada.close();
		salida.close();
		
	}

}
