package ar.com.eduit.clase2;

public class MainAuto {

	public static void main(String[] args) {

		Auto clioVerde = new Auto();
		
		clioVerde.anio = 2020;//f6
		clioVerde.canidadCombustible = 10f;
		clioVerde.chasis=123456789l;
		clioVerde.color="verde";
		
		// clioVerde.marca="renault";
		clioVerde.setMarca("renault");
		
		clioVerde.setModelo("clio");
		//clioVerde.velocidad=0f;
		
		clioVerde.informar();//f3
		System.out.println("---------------");
		clioVerde.encender();
		
		for(int i=0; i < clioVerde.velocidadMaxima; i++) {
			clioVerde.acelerar();
			clioVerde.frenar();
		}
		
		//mietras el auto tengo combustible acelero 
		while(clioVerde.canidadCombustible > 0) {
			clioVerde.acelerar();
		}
		
		clioVerde.informar();//f3
	}

}
