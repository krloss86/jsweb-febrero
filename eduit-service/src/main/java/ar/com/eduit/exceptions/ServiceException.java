package ar.com.eduit.exceptions;

/**
 * Exception de capa de servicio
 * @author CHLopez
 *
 */
public class ServiceException extends Exception {

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
