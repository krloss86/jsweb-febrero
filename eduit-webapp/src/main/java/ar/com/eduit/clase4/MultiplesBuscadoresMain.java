package ar.com.eduit.clase4;

import ar.com.eduit.clase3.Articulo;
import ar.com.eduit.clase3.Buscador;

public class MultiplesBuscadoresMain {

	public static void main(String[] args) {
		
		String clave = "iron man";
		
		//simular que el usuario marco dos buscadores
		Integer[] opciones = new Integer[] {3,2};
				
		//for porque tengo que recorrer un vector/array
		//for each
		
		//array de buscadores
		Buscador[] buscadores = new Buscador[opciones.length];
		
		int i = 0;
		for(Integer opcion : opciones ) {
			
			//PADRE
			Buscador buscador;
			if(opcion == 2) {
				//NEW HIJO
				buscador = new BuscadorPelicula();
			}else if(opcion == 3) {
				//NEW HIJO
				buscador = new BuscadorMusica();
			} else {
				//NEW HIJO
				buscador = new BuscadorDefecto();
			}
			
			buscador.setClaveBusqueda(clave);			
			buscadores[i++] = buscador;			
		}
		
		//EJECUTAR TODAS LAS BUSQUEDAS 

		//DATOS DEL FILTRO
		Float min = 1500f;
		Float max = 2000f;
		
		//PODEMOS APLICAR LOS FILTROS!
		IFiltro filtroPrecio = new FiltroPrecio(min, max);
		IFiltro filtroTitulo = new FiltroFormato("LIBROS");
		
		for(Buscador buscador  : buscadores ) {
			
			buscador.addFiltro(filtroTitulo);
			//buscador.addFiltro(filtroPrecio);
			
			//para cada buscador ejecuto su metodo buscar
			buscador.buscar();//POLIMORFISMO
			
			buscador.aplicarFiltros();
			
			//tomar los datos
			Articulo[] articulos = buscador.getResultados();
			
			for(Articulo articulo : articulos) {
				
				if(articulo !=null) {
					//informo los datos del articulo
					articulo.informar();
					System.out.println("-------");
				}
			}
		}
	}

}
