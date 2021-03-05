package ar.com.eduit.clase5.interfaces;

public class FileSystemLog implements ILogger {

	@Override
	public void log() {
		// crear un archivo en el file system
		System.out.println("Creando archivo en fs");
	}

}
