package ar.com.eduit.clase3;

public class Pasatiempo extends Articulo {

	private String marca;//alt+shit+r
	
	public Pasatiempo(String titulo, Float precio, String autor, String marca) {
		
		//primero nace el padre
		super(titulo, precio, autor);
		
		//luego el hijo	
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	//cambia el comportamiento de padre
	public void informar() {
		super.informar();
		System.out.println("Marca:" + this.marca);
	}
}
