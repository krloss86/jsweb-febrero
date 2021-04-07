package ar.com.eduit.clase5.interfaces2;

public class Mujer extends Persona {

	public Mujer(String nombre, String apellido, String genero, IIdioma idiomaNativo) {
		super(nombre, apellido, genero, idiomaNativo);
	}

	
	public void hablar(String palabra) {
		System.out.println("Soy" + this.getNombre() + " " + this.getApellido() + " " + this.getGenero());
		super.hablar(palabra);
	}
}
