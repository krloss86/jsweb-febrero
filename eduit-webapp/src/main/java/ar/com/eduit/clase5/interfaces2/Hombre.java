package ar.com.eduit.clase5.interfaces2;

public class Hombre extends Persona {

	public Hombre(String nombre, String apellido, String genero, IIdioma idiomaNativo) {
		super(nombre, apellido, genero, idiomaNativo);		
	}

	public void hablar(String palabra) {
		System.out.println("Soy" + this.getNombre() + " " + this.getApellido() + " " + this.getGenero());
		super.hablar(palabra);
	}
}
