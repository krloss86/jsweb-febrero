package ar.com.eduit.clase3;

public class Pelicula extends Articulo {

	private String productora;
	private String sinopsis;
	
	public Pelicula(String titulo, Float precio, String autor, String productora, String sinopsis) {
		super(titulo, precio, autor);		
		this.productora = productora;
		this.sinopsis = sinopsis;
	}
		
	//cambia el comportamiento de padre
	public void informar() {
		super.informar();
		System.out.println("Productora: " + this.productora);
		System.out.println("Sinopsis: " + this.sinopsis);
	}

	public String getProductora() {
		return productora;
	}

	public void setProductora(String productora) {
		this.productora = productora;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

}
