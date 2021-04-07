package ar.com.eduit.clase3;

import ar.com.eduit.clase4.FiltroPrecio;
import ar.com.eduit.clase4.IFiltro;

public abstract class Buscador {

	protected IFiltro[] filtros = new IFiltro[0];
	
	private String claveBusqueda;
	
	private Articulo[] resultados;
	
	private Integer total;

	public abstract void buscar();
	
	public void actualizarResultado(Articulo articulo) {
		this.resultados = new Articulo[1];
		this.resultados[0] = articulo;
		
		this.total = this.resultados.length;
	}
	
	public void actualizarResultado(Articulo[] articulos) {
		this.resultados = articulos;
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

	public void filtrarResultados(Float min, Float max) {		
		//creamos el filtro
		FiltroPrecio filtro = new FiltroPrecio(min, max);
		this.resultados = filtro.filtrar(this.resultados);
	}
	
	public void addFiltro(IFiltro filtro) {	
		if(filtro != null) {
			IFiltro[] nuevosFiltros = new IFiltro[this.filtros.length+1];
			int i=0;
			for(IFiltro filtroInterno : this.filtros) {
				nuevosFiltros[i++] = filtroInterno;
			}
			nuevosFiltros[i] = filtro;
			this.filtros = nuevosFiltros; 
		}
	}
	
	public void aplicarFiltros() {
		if(this.tieneFiltros()) {
			//aplicamos los filtros!
			Articulo[] resultadosFiltrados = new Articulo[this.resultados.length];
			int i=0;
			for(IFiltro filtro : this.filtros) {								
				Articulo[] filtrados = filtro.filtrar(this.resultados);//POLIMORFISMO
				
				for(Articulo aux : filtrados) {
					resultadosFiltrados[i++] = aux;
				}
			}
			this.resultados = resultadosFiltrados;
		}
	}
	
	public boolean tieneFiltros() {
		return this.filtros.length > 0;
	}
}
