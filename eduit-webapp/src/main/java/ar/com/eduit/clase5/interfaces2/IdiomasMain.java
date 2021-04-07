package ar.com.eduit.clase5.interfaces2;

public class IdiomasMain {

	public static void main(String[] args) {
				
		Persona[] personas = crearPersonas();
		
		for(Persona alguien: personas) {
			
			alguien.hablar("clase5 jsweb");
		}
		
		System.out.println("Fin");
	}

	//está en otra clase!!!
	public static Persona[] crearPersonas() {
		
		/*
		IIdioma xxx = new IIdioma() {			
			public void hablar() {
				home work!			
			}
		};*/
		
		//CREAR EL IDIOMA 
		IIdioma ie = new Espanol();//espanol implemeta IIdioma, se comporta como IIdioma
		
		//Persona juan = new Persona("JUAN", "PEREZ", ie );//porque persona es abstracta
		Persona maria = new Mujer("JUAN", "PEREZ", "generoX", ie);
		
		IIdioma ingles = new Ingles();//Interface i = new ClaseImplementa();	
		maria.aprender(ingles);
		
		IIdioma chino = new Chino();//implementa la interface IIdioma, se comporta como IIdioma
		
		Persona juan = new Hombre("JUAN", "PEREZ", "generoX", chino);
		
		Persona[] personas = new Persona[] {maria, juan};
		
		return personas;
	}
}
