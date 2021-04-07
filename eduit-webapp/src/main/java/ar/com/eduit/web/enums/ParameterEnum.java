package ar.com.eduit.web.enums;

public enum ParameterEnum {

	USERNAME("username"),
	PASSWORD("password"), 
	USER("user"), 
	CLAVE_BUSQUEDA("claveBusqueda"), 
	LISTADO("listado"), 
	ERROR("error"), 
	TITULO("titulo"),
	PRECIO("precio"), 
	CODIGO("codigo"), 
	TIPO_PRODUCTO("tipoProducto"), 
	EXITO("exito"), 
	ID_PRODUCTO("id"), 
	PRODUCTO("producto"), 
	TOTAL_LISTADO("total"), 
	TITULO_FILTRO("tituloFiltro"), 
	PRECIO_FILTRO("precioFiltro"), 
	TIPO_PRODUCTO_FILTRO("tipoProductoFiltro");
	
	private String param;
	
	private ParameterEnum(String param) {
		this.param = param;
	}

	public String getParam() {
		return param;
	}
	
}
