package ar.com.eduit.clase5.interfaces;

public class EmailLogger implements ILogger {

	private String email;
	
	public EmailLogger(String email) {	
		//no necesito llamar al constructor del padre
		this.email = email;
	}
	
	@Override
	public void log() {
		System.out.println("Enviando un mail a: "+ this.email);		
	}

}
