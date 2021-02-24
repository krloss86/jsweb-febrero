package ar.com.eduit.clase2;

public class MainClase2 {

	//UPPER CAMEL CASE
	//ClaseMaMeMiMo
	
	//LOWER
	//claseMaMeMiMo: atributos y métodos
	
	//punto de entrada
	public static void main(String[] args) {
				
		//INSTANCIAR UN OBJETO DE LA CLASE AUTO
		Auto clioVerde = new Auto();
		//f6 linea a linea
		//f5 entrar al métodos
		//f7 volver hacia quien invocó
		//f8 a partir de la linea donde este "parado" ejecuta hasta el final o el próximo break point
		
		//a partir de acá, el objeto clioVerde está vivo
		
		//asignar valor a los atributos del objeto clioVerder
		clioVerde.anio = 2020;//f6
		clioVerde.canidadCombustible = 10f;
		clioVerde.chasis=123456789l;
		clioVerde.color="verde";
		clioVerde.marca="renault";
		clioVerde.modelo="clio";
		clioVerde.velocidad=0f;
				
		System.out.println(clioVerde.anio);
	}//f8

}
