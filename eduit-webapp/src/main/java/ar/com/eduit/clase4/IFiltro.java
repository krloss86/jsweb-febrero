package ar.com.eduit.clase4;

import ar.com.eduit.clase3.Articulo;

// hasta java 7
public interface IFiltro {
		
	public Articulo[] filtrar(Articulo[] resultados);
	
	//a partir de java 8
	public default Articulo[] filtrarDefecto(Articulo[] resultados) {
		return resultados;
	}
}
