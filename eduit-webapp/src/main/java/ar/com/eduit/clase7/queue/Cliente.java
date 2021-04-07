package ar.com.eduit.clase7.queue;

public class Cliente implements Comparable<Cliente>{

	private Long id;
	private String nombre;
	private CategoriaEnum categoria;
	
	public Cliente(Long id, String nombre, CategoriaEnum categoria) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CategoriaEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEnum categoria) {
		this.categoria = categoria;
	}

	@Override
	public int compareTo(Cliente otroCliente) {
		//return otroCliente.getId().compareTo(this.getId());
		return otroCliente.getCategoria().compareTo(this.getCategoria());
	}

	@Override
	public String toString() {
		return "Cliente {id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + "}";
	}
	
	/*@Override
	public String toString() {
		
		//armar la representacion de un cliente:
		StringBuffer str = new StringBuffer();
		
		//id:, nombre: , categ: 
		str.append("ID: ").append(this.getId()).append(",");
		str.append("Nombre: ").append(this.getNombre()).append(",");
		str.append("Categoria: ").append(this.getCategoria()).append("\n");
		
		return str.toString();
	}*/
	
	
}
