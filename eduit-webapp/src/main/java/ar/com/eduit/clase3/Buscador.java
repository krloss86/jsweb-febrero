package ar.com.eduit.clase3;

public class Buscador {

	private String claveBusqueda;
	
	private Articulo[] resultados;
	
	private Integer total;

	public final void buscar() {
		
		//SIMULAR la busqueda en db, excel, nobe etc etc..
		
		//select * from articulo where titulo like ''
		
		//libro
		//Padre p = new Hijo();
		Articulo resultado1 = new Libro("TONY STAR IRON MAN 01: UN..." , 760f, "SLOTT, DAN", "9786076343043");
		//pelicula
		Articulo resultado2 = new Pelicula("INVENCIBLE IRON MAN, EL ...", 1325f, "BENDIS, BRIAN MICHAEL", "THE WALT DISNEY COMPANY","Marvel Studios (The Avengers: Los Vengadores de Marvel) lanza la mejor aventura de Iron Man hasta ahora; un fenómeno global sin precedentes...");
		//pasatiempo
		Articulo resultado3 = new Pasatiempo("IRON MAN 15 CENTIMETROS -", 1117.99f, "" , "Hasbro");
		//musica
		String[] temas = new String[] {"SHOOT OT THRILL", "ROCK N ROLL DAMNATION"};		
		Articulo resultado4 = new Musica("IRON MAN 2 (STANDARD)", 1033f, "AC/DC", "SONY MUSIC", temas );
				
		//vectores/array!!!
		this.resultados = new Articulo[4];
		//0,1,2,3
		this.resultados[0] = resultado1;
		this.resultados[1] = resultado2;
		this.resultados[2] = resultado3;
		this.resultados[3] = resultado4;
		
		this.total = this.resultados.length;		
	}
	
	public String getClaveBusqueda() {
		return claveBusqueda;
	}

	public void setClaveBusqueda(String claveBusqueda) {
		this.claveBusqueda = claveBusqueda;
	}

	public Articulo[] getResultados() {
		return resultados;
	}
	
	public Integer getTotal() {
		if(this.total == null) {
			this.total = 0;
		}
		return this.total;
	}
	
}
