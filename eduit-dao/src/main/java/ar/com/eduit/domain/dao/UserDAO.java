package ar.com.eduit.domain.dao;

import ar.com.eduit.domain.User;
import ar.com.eduit.domain.dao.exceptions.GenericException;

public interface UserDAO {

	public User findByUsername(String username) throws GenericException;
}
