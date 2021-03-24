package ar.com.eduit.parsers;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.parsers.enums.FileEnum;

public abstract class FileParserBase {

	private FileEnum type;
	
	private String name;
	
	//protected Part filePart;
	public FileParserBase(FileEnum type, String name) {
		this.type = type;
		this.name = name;
	}

	/**
	 * Convierte una linea en un Producto<br> 
	 * ej: carpeta n3;250;car001;5
	 * @param unaLinea
	 * @return
	 */
	public Producto buildProducto(String unaLinea) {
		String[] datos = unaLinea.split(";");
		String titulo =  datos[0];
		String precio = datos[1];
		String codigo = datos[2];
		String tipoProducto = datos[3];
		
		return new Producto(titulo, Float.parseFloat(precio), codigo, Long.parseLong(tipoProducto));		
	}
	
	public FileEnum getType() {
		return type;
	}

	public void setType(FileEnum type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
