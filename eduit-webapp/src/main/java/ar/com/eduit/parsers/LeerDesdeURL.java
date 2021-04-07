package ar.com.eduit.parsers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class LeerDesdeURL {

	public static void main(String[] args) throws IOException {
		
		//leer una web
		
		URL url = new URL("https://www.clarin.com");

		InputStream io = url.openConnection().getInputStream();
		
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(io));
		
		StringBuffer html = new StringBuffer();
		
		//leer 
		String unaLinea;
		while((unaLinea = bufferReader.readLine()) != null) {
			html.append(unaLinea);			
		}		
		
		bufferReader.close();
		
		File htmlFile = new File("c:/data/clarin-html.html");
		
		FileWriter fr = new FileWriter(htmlFile);
				
		fr.write(html.toString());
		
		fr.close();
	}

}
