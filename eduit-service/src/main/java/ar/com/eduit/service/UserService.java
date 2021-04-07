package ar.com.eduit.service;

import ar.com.eduit.domain.User;
import ar.com.eduit.exceptions.ServiceException;

public interface UserService {

	public User obtenerUsuario(String username) throws ServiceException;
}
