package ar.com.eduit.controller;

import java.util.Scanner;

import ar.com.eduit.acciones.AccionBase;
import ar.com.eduit.acciones.AltaAccion;
import ar.com.eduit.exceptions.ServiceException;
import ar.com.eduit.interfaces.IAccion;

public class CrudProductoMain {

	public static void main(String[] args) throws ServiceException {
		
		Scanner teclado = new Scanner(System.in);	
		
		Integer opcion;
		do {
			System.out.println("Ingrese una opcion:");
			System.out.println("1 - Alta");
			System.out.println("2 - Baja");
			System.out.println("3 - Modificación");
			System.out.println("4 - Consulta");
			opcion = teclado.nextInt();
		}while(opcion < 0 || opcion > 4);
		
		IAccion accion = null;
		switch (opcion) {
		case 1:
			accion = new AltaAccion();
			break;
		/*case 2:
			accion = new BajaAccion();
			break;
		case 3:
			accion = new ModificacionAccion();
			break;
		case 4:
			accion = new ConsultaAccion();
			break;*/
		}
		((AccionBase)accion).setTeclado(teclado);
		
		accion.execute();
			
		teclado.close();
	}

}
