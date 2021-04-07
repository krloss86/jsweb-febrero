package ar.com.eduit.clase4;

import ar.com.eduit.clase3.Articulo;
import ar.com.eduit.clase3.Buscador;
import ar.com.eduit.clase3.Pelicula;

public class BuscadorPelicula extends Buscador {
		
	public void buscar() {

		Articulo resultado2 = new Pelicula("INVENCIBLE IRON MAN, EL ...", 1325f, "BENDIS, BRIAN MICHAEL", "THE WALT DISNEY COMPANY","Marvel Studios (The Avengers: Los Vengadores de Marvel) lanza la mejor aventura de Iron Man hasta ahora; un fenómeno global sin precedentes...");
				
		super.actualizarResultado(resultado2);
	}
}
