package ar.com.eduit.clase4;

import ar.com.eduit.clase3.Articulo;

public class FiltroPrecio implements IFiltro {

	private Float min;
	private Float max;
	
	public FiltroPrecio(Float min, Float max) {
		this.min = min;
		this.max = max;
	}
	
	public Articulo[] filtrar(Articulo[] resultados) {
		//LOGICA...
		
		int cantidadFiltrados = 0;
		for(Articulo resultado : resultados) {
			if(resultado.getPrecio() >= this.min 
					&& resultado.getPrecio() <=max) {
				cantidadFiltrados++;
			}
		}
		
		Articulo[] resultadosFiltrados = new Articulo[cantidadFiltrados];
		
		int i=0;
		for(Articulo resultado : resultados) {
			if(resultado.getPrecio() >= this.min 
					&& resultado.getPrecio() <=max) {
				resultadosFiltrados[i++]=resultado;
			}
		}
		return resultadosFiltrados;
	}
	
}
