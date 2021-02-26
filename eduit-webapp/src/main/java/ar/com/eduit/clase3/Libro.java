package ar.com.eduit.clase3;

public class Libro extends Articulo {

	private String isbn;//ATRIBUTOS DE INSTANCIA
	
	public static String TABLA = "TBL_LIBRO"; //ATRIBUTOS DE CLASE
	
	public Libro(String titulo, Float precio, String autor, String isbn) {
		
		//primero nace el padre
		super(titulo, precio, autor);
		
		//luego el hijo	
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	//cambia el comportamiento de padre
	public void informar() {
		super.informar();
		System.out.println("ISBN:" + this.isbn);
	}
}
