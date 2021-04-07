package ar.com.eduit.web.enums;

public enum ViewEnums {

	LOGIN_SUCCESS("/loginSuccess.jsp"),
	LOGIN("/login.jsp"), 
	LISTADO("/jsp/listado.jsp"), 
	NUEVO("/jsp/nuevo.jsp"), 
	EDITAR("/jsp/editar.jsp");
	
	private String jsp;
	
	private ViewEnums(String jsp){
		this.jsp = jsp;
	}

	public String getJsp() {
		return jsp;
	}
	
}
