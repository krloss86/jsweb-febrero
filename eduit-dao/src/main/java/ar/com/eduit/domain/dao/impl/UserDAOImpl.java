package ar.com.eduit.domain.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.domain.User;
import ar.com.eduit.domain.dao.AdministradorDeConexiones;
import ar.com.eduit.domain.dao.UserDAO;
import ar.com.eduit.domain.dao.exceptions.GenericException;

public class UserDAOImpl implements UserDAO {

	private Connection getCurrentConnection() throws GenericException{
		try {
			return AdministradorDeConexiones.obtenerConexion();
		} catch (Exception e) {
			throw new GenericException("No se ha podido obtener una conexion",e);
		}
	}
	
	@Override
	public User findByUsername(String username) throws GenericException {
		String sqlSelect = "SELECT * FROM USER WHERE UPPER(USERNAME) = '"+username.toUpperCase()+"'";
		
		User user = null;
		
		Connection connection = getCurrentConnection();
		
		try {
			
			PreparedStatement st = connection.prepareStatement(sqlSelect);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Long pk = rs.getLong(1);// PK
				String _username = rs.getString(2);
				String password = rs.getString(3);
				
				user = new User(pk, _username, password);
			}
			
			return user; 
		} catch (SQLException e) {
			throw new GenericException("No se ha podido obtener el usuario", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e);
			}
		}
	}

}
