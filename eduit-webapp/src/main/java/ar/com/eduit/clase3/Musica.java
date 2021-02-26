package ar.com.eduit.clase3;

public class Musica extends Articulo {

	private String[] temas;
	private String selloDiscografico;
	
	public Musica(String titulo, Float precio, String autor, String sello, String[] temas) {
		super(titulo, precio, autor);		
		this.selloDiscografico = sello;
		this.temas = temas;
	}
		
	//cambia el comportamiento de padre
	public void informar() {
		super.informar();
		if(this.temas != null) {
			System.out.println("Lista de temas:");
			int numero = 1;
			for(String tema : temas) {
				System.out.println((numero++) + "- " + tema);
			}
		}
		System.out.println("Sello Discográfico: " + this.selloDiscografico);
	}

	public String[] getTemas() {
		return temas;
	}

	public void setTemas(String[] temas) {
		this.temas = temas;
	}

	public String getSelloDiscografico() {
		return selloDiscografico;
	}

	public void setSelloDiscografico(String selloDiscografico) {
		this.selloDiscografico = selloDiscografico;
	}
	//get/set
}
