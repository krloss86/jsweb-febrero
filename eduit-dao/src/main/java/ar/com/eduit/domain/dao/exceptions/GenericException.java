package ar.com.eduit.domain.dao.exceptions;

public class GenericException extends Exception {

	public GenericException(String msj, Throwable e) {
		super(msj, e);
	}
	
}
