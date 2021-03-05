package ar.com.eduit.clase5;

//HIJO DE FIGURA
//PADRE DE CUADRADO
public class Rectangulo extends Figura {

	private Float lado1;	
	private Float lado2;
		
	//constructor
	public Rectangulo(Float lado1, Float lado2) {
		this.lado1 = lado1;
		this.lado2 = lado2;
	}
			
	@Override
	public void calcularArea() {
		
		super.setArea(lado1 * lado2);
		
		this.setArea(lado1 * lado2);
		
		setArea(lado1 * lado2);
	}

	//polimorfismo con redefinicion
	public void informarArea() {
		System.out.println("Calculando el area de un cuadrado de lado1="+this.lado1 +" y lado2="+this.lado2 );
		//el padre tiene area como protected -> private
		
		System.out.println(this.getArea());
	}

	public Float getLado1() {
		return lado1;
	}


	public void setLado1(Float lado1) {
		this.lado1 = lado1;
	}


	public Float getLado2() {
		return lado2;
	}


	public void setLado2(Float lado2) {
		this.lado2 = lado2;
	}

	//get/set
	//alt+shit+s
	
}
