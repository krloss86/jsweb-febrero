package ar.com.eduit.clase4;

import ar.com.eduit.clase3.Articulo;
import ar.com.eduit.clase3.Buscador;
import ar.com.eduit.clase3.Libro;
import ar.com.eduit.clase3.Musica;
import ar.com.eduit.clase3.Pasatiempo;
import ar.com.eduit.clase3.Pelicula;

public class BuscadorGeneral extends Buscador {

	public void buscar() {

		//libro
		//Padre p = new Hijo();
		Articulo resultado1 = new Libro("TONY STAR IRON MAN 01: UN..." , 760f, "SLOTT, DAN", "9786076343043");
		//pelicula
		Articulo resultado2 = new Pelicula("INVENCIBLE IRON MAN, EL ...", 1325f, "BENDIS, BRIAN MICHAEL", "THE WALT DISNEY COMPANY","Marvel Studios (The Avengers: Los Vengadores de Marvel) lanza la mejor aventura de Iron Man hasta ahora; un fenómeno global sin precedentes...");
		//pasatiempo
		Articulo resultado3 = new Pasatiempo("IRON MAN 15 CENTIMETROS -", 1117.99f, "" , "Hasbro");
		//musica
		String[] temas = new String[] {"SHOOT OT THRILL", "ROCK N ROLL DAMNATION"};		
		Articulo resultado4 = new Musica("IRON MAN 2 (STANDARD)", 1033f, "AC/DC", "SONY MUSIC", temas );
				
		//ctrl+shit+o
		
		//vectores/array!!!
		Articulo[] resultados = new Articulo[] {resultado1, resultado2, resultado3, resultado4};
		super.actualizarResultado(resultados);
	}
}
