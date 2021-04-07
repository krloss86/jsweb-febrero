package ar.com.eduit.clase5.interfaces2;

public abstract class Persona {

	private IIdioma idiomaNativo;
	private String nombre;
	private String apellido;
	private String genero;
	private IIdioma[] idiomas;
	
	public Persona(String nombre, String apellido, String genero, IIdioma idiomaNativo) {	
		this.nombre = nombre;
		this.apellido = apellido;
		this.idiomaNativo = idiomaNativo;
		this.genero = genero;
		this.idiomas = new IIdioma[]{};
	}

	public void aprender(IIdioma nuevoIdioma) {
		if(this.idiomas.length == 0) {
			this.idiomas = new IIdioma[1];
			this.idiomas[0] = nuevoIdioma;
		}else {
			IIdioma[] idiomasNuevos = new IIdioma[this.idiomas.length+1];
			int i=0;
			for(IIdioma idiomaSabe : this.idiomas) {
				idiomasNuevos[i] = idiomaSabe;				
			}
			idiomasNuevos[i] = nuevoIdioma;
			this.idiomas = idiomasNuevos;
		}
	}
	
	public void hablar(String palabra) {
		
		System.out.println("EN idioma nativo:");
		this.idiomaNativo.hablar(palabra);//polimorfismo y "dinamic binding"
		
		System.out.println("En otros idiomas...");
		//for
		for(IIdioma idioma  : this.idiomas ) {
			idioma.hablar(palabra);
		}
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public IIdioma getIdiomaNativo() {
		return idiomaNativo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public IIdioma[] getIdiomas() {
		return idiomas;
	}
	
	
}
