package ar.com.eduit.domain.dao.exceptions;

import java.sql.SQLException;

public class GenericException extends Exception {

	public GenericException(String msj, SQLException e) {
		super(msj, e);
	}

}
