package ar.com.eduit.clase5.exceptions;

public class Calculadora {

	private int valor1;
	private int valor2;
	private int resultado;

	//alt+shits
	public Calculadora(int valor1, int valor2) {
		this.valor1 = valor1;
		this.valor2 = valor2;
	}

	public void dividir() throws MiException, LogException {
		
		if(this.valor1 == 0) {
			LogException le = new LogException("No se puede calcular un log negativo");
			throw le;
		}
		
		if(this.valor2 != 0) {
			this.resultado = valor1 / valor2;
		}else {
			//CREO MiException con un mensaje
			MiException checkedException = new MiException("No se puedo divir por 0");
			//LANZAR
			throw checkedException;
		}
	}
	
	public int getValor1() {
		return valor1;
	}

	public void setValor1(int valor1) {
		this.valor1 = valor1;
	}

	public int getValor2() {
		return valor2;
	}

	public void setValor2(int valor2) {
		this.valor2 = valor2;
	}

	public int getResultado() {
		return resultado;
	}
	
}
