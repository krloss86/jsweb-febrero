package ar.com.eduit.domain.dao.exceptions;

import java.sql.SQLException;

public class DuplicatedException extends Exception {

	public DuplicatedException(String msj, SQLException e) {
		super(msj,e);
	}

}
