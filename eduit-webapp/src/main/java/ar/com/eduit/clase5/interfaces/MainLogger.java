package ar.com.eduit.clase5.interfaces;

import java.util.Scanner;

public class MainLogger {

	public static void main(String[] args) {
	
		System.out.println("Ingrese tipo de log "
				+ "1 - console"
				+ "2 - email"
				+ "3 file system");
		Scanner teclado = new Scanner(System.in);//leer del teclado!!!
		
		Integer opcion =  teclado.nextInt();

		ILogger logger;
		switch (opcion) {
			case 1:
				logger = new ConsoleLog();
				break;
			case 2:
				logger = new EmailLogger("alguien@mail.com");
				break;
			case 3:
				logger = new FileSystemLog();
				break;
			default:
				logger = new ConsoleLog();
				break;				
		}
		
		logger.log();
		logger = new EmailLogger("alguien@mail.com");
		
		logger.log();
	}

}
