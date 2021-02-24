package ar.com.eduit.clase1;

public class Programa1 {

	public static void main(String[] args) {
		
		//variables, identificadores, tipos de datos
		//operadores
		
		//primitivos
		byte valor = 1;
		short vShort = 257;
		int cantidad = 21;
		long valorLong = 100000000;
		
		//decimales
		float vFloat = 10.5f;
		double vDouble = 10.5;
		
		//numéricos
		// byte < short < int < long < float < double
				
		//caracteres
		char vChar = 'a';	
		String nombre = "Joel";
		
		//verdadero o falso
		boolean jueves = true;
		boolean viernes = false;
		
		//wrapper : Clases		
		Integer vInteger = 10;
		Byte vByte = 1;
		Double vDoubleW = 100.5;
		Float vFloatW = 100.5f;
		
		Character vCharW = 'c';
		
		char[] nombreChar = new char[] {'c','a','r','l','o','s'};
		String vString = "carlos";
		//---------------------
		
		Double d = Double.parseDouble(vString);
		
	}
}
