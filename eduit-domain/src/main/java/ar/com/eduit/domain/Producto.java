package ar.com.eduit.domain;

/**
 * Representa la tabla productos
 * @author CHLopez
 *
 */
public class Producto {

	private Long id;
	private String titulo;
	private Float precio;
	private String codigo;
	private Long tipoProducto;

	public Producto(Long id, String titulo, Float precio, String codigo, Long tipoProducto) {
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.codigo = codigo;
		this.tipoProducto = tipoProducto;
	}
	
	public Producto(String titulo, Float precio, String codigo, Long tipoProducto) {
		this.titulo = titulo;
		this.precio = precio;
		this.codigo = codigo;
		this.tipoProducto = tipoProducto;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Long getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(Long tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", codigo=" + codigo
				+ ", tipoProducto=" + tipoProducto + "]";
	}
	
}
