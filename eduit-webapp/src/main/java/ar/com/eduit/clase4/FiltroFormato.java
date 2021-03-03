package ar.com.eduit.clase4;

import ar.com.eduit.clase3.Articulo;

public class FiltroFormato implements IFiltro {

	private String formato;
	
	public FiltroFormato(String formato) {
		this.formato = formato;
	}
	
	public Articulo[] filtrar(Articulo[] resultados) {
		//LOGICA...
		
		int cantidadFiltrados = 0;
		for(Articulo resultado : resultados) {
			if(resultado.getTitulo().contains(this.formato)) {
				cantidadFiltrados++;
			}
		}
		
		if(cantidadFiltrados > 0) {
			Articulo[] resultadosFiltrados = new Articulo[cantidadFiltrados];
			
			int i=0;
			for(Articulo resultado : resultados) {
				if(resultado.getTitulo().contains(this.formato)) {
					resultadosFiltrados[i++]=resultado;
				}
			}
			return resultadosFiltrados;
		}else {
			return resultados;
		}
	}
	
}
