package ar.com.eduit.clase2;

public class MainAutoEncapsulado {

	public static void main(String[] args) {
		
		Auto clio = new Auto();
		
		//clio.marca = "renaul";
		clio.setMarca("Renault");
		
		String marca = clio.getMarca();
		
		clio.informar();
	}

}
