package ar.com.eduit.clase5;

// PADRE
public abstract class Figura {

	private Float area;
	
	//con esto obliga las clases hijas a definir si o si la lógica de cálculo
	public abstract void calcularArea();
	
	public Float getArea() {
		return this.area;
	}
	
	public void informarArea() {
		//mostrar el area de la figura!
		System.out.println("Area:" + this.area);
	}
	
	//ahora solo se puede llegar al area por medio del setter
	protected void setArea(Float area) {
		this.area = area;
	}
	
}
