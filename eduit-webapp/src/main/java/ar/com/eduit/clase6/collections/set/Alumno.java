package ar.com.eduit.clase6.collections.set;

public class Alumno  implements Comparable<Alumno> {

	private Long id;
	private String nombre;
	
	public Alumno(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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
	
	// a y b
	// a - b ==0 => iguales
	// a -b < 0 => b es mayor que a
	// a -b > 0 => a es ayor que b
	public int compareTo(Alumno otro) {
		/*
		long resta = this.id - otro.id;
		
		return (int)resta;
		*/
		
		return this.id.compareTo(otro.getId());
	}
	
	
}
