package ar.com.eduit.clase4;

import ar.com.eduit.clase3.Articulo;
import ar.com.eduit.clase3.Buscador;
import ar.com.eduit.clase3.Musica;

public class BuscadorMusica extends Buscador {
		
	//estoy obligado a implementar el metodo abstracto buscar
	public void buscar() {
		
		//SELECT * FROM ARTICULO WHERE TIPO=3
		
		//musica
		String[] temas = new String[] {"SHOOT OT THRILL", "ROCK N ROLL DAMNATION"};		
		Articulo resultado4 = new Musica("IRON MAN 2 (STANDARD)", 1033f, "AC/DC", "SONY MUSIC", temas );		
		Articulo resultado5 = new Musica("IRON MAN 3 (STANDARD)", 1033f, "AC/DC", "SONY MUSIC", temas );		
		Articulo resultado6 = new Musica("IRON MAN 3 (STANDARD)", 1033f, "AC/DC", "SONY MUSIC", temas );
				
		/*super.actualizarResultado(resultado4);
		super.actualizarResultado(resultado5);
		super.actualizarResultado(resultado6);*/
		
		Articulo[] articulos = new Articulo[] {resultado4, resultado5, resultado6};
		
		super.actualizarResultado(articulos);
	}
}
