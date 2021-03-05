package ar.com.eduit.clase5.exceptions;

import ar.com.eduit.clase5.interfaces2.Espanol;
import ar.com.eduit.clase5.interfaces2.Mujer;
import ar.com.eduit.clase5.interfaces2.Persona;

public class ExceptionsMain {

	public static void main(String[] args) {
		/*
		String saludo = null;
		
		System.out.println(saludo.length());
		*/		
		
		/*Persona maria = new Mujer("JUAN", "PEREZ", "generoX", new Espanol());
		
		//tiempo de compilacion
		Persona h = (Persona)maria;
		
		System.out.println(h.getApellido());*/
		
		Calculadora c = new Calculadora(1, 0);
		 
		//dentro pongo que quiero que suceda de manera exitosa 
		try {
			c.dividir();//f5
			System.out.println(c.getResultado());
		} catch( MiException | LogException e ) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		} finally {
			System.out.println("Siempre se ejecuta este codigo...");
		}
		
		System.out.println("Fin");
	}

}
