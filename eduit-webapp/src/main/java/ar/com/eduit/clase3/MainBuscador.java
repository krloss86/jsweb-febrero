package ar.com.eduit.clase3;

import ar.com.eduit.clase4.BuscadorGeneral;

public class MainBuscador {

	public static void main(String[] args) {
		
		String claveBusquedaIngresadaPorElUsuario = "iron man";

		//crear una instancia de buscador SI
		Buscador buscador = new BuscadorGeneral();
		buscador.setClaveBusqueda(claveBusquedaIngresadaPorElUsuario);
		
		//ejecuto la busqueda
		buscador.buscar();
		
		//mostrar los datos
		Articulo[] resultados = buscador.getResultados();
		
		/*
		for(int i=0; i < buscador.getTotal(); i++) {
			Articulo resultado = resultados[i];
			resultado.informar();
		}
		*/
		for(Articulo resultado :  resultados) {
			//LIBRO
			//MUSICA
			//PASATIEMPO
			//PELICULA
			System.out.println(Articulo.TIPO);
			resultado.informar();//POLIMORFISMO
			System.out.println("-----");
		}
	}

}
