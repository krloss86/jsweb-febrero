package ar.com.eduit.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.parsers.enums.FileEnum;

public class CSVFileParser extends FileParserBase implements IFileParser<Collection<Producto>> {

	public CSVFileParser(String name) {
		super(FileEnum.CSV, name);
	}

	@Override
	public Collection<Producto> parse() throws IOException {
		
		File file = new File(super.getName());//super.|this.| name
		
		if(!file.exists()) {
			throw new FileNotFoundException(getName() + " No existe");
		}
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		
		String unaLinea = br.readLine();
		
		Collection<Producto> productos = new  ArrayList<Producto>();
		
		while((unaLinea = br.readLine()) != null  ) {
			
			Producto producto = super.buildProducto(unaLinea);
			
			productos.add(producto);
		}
		
		br.close();
		
		return productos;
	}

}
