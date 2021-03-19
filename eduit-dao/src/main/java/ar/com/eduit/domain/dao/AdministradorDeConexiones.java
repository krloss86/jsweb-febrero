package ar.com.eduit.domain.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradorDeConexiones {
	
	public static Connection obtenerConexion() throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		
		String dbConnectionUrl = "jdbc:mysql://127.0.0.1/jsweb-febrero?serverTimeZone=UTC&useSSL=false";
		
		String username = "root";
		
		String password = "root";
		
		try {
			
			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(dbConnectionUrl, username, password);
			
			return connection;
		}catch(Exception e) {
			throw e;
		}
	}		
}
