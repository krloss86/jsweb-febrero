package ar.com.eduit.clase5.interfaces;

public class ConsoleLog implements ILogger {

	@Override
	public void log() {
		System.err.println("Informando solo por consola...");		
	}

}
