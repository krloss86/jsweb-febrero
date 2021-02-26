package ar.com.eduit.clase3;

public class Articulo {

	//ATRIBUTOS
	protected String titulo;
	protected String autor;
	protected Float precio;
	protected String imagen;
	
	public static String TIPO = "articulo";
	
	//CONSTRUCTORES
	public Articulo(
			String titulo,
			Float precio,
			String autor) {
		this.titulo = titulo;
		this.precio = precio;
		this.autor = autor;
	}
	
	public Articulo(
			String titulo,
			Float precio) {
		
		this.titulo = titulo;
		this.precio = precio;		
	}

	//GET/SET
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	//los hijos no podran modificar este comportamiento
	public void informar() {
		System.out.println("Titulo: " + this.titulo);
		
		if(autor != null) {
			System.out.println("Autor:" + this.autor);
		}
		
		System.out.println("Precio:" + this.precio);
	}
	
	
}
