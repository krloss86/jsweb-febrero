package ar.com.eduit.clase5;

public class FiguraMain {

	public static void main(String[] args) {
		
		Rectangulo c = new Rectangulo(10f,20f);
		c.calcularArea();
		c.informarArea();
		
		c.setArea(15f);
		
		Rectangulo c1 = new Rectangulo(5f,10f);
		c1.calcularArea();
		c1.informarArea();
	}

}
