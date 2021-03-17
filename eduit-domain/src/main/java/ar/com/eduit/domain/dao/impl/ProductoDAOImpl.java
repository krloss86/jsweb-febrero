package ar.com.eduit.domain.dao.impl;

//JDBC
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
//jdbc
import java.util.Collection;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.domain.dao.AdministradorDeConexiones;
import ar.com.eduit.domain.dao.ProductoDAO;
import ar.com.eduit.domain.dao.exceptions.DuplicatedException;
import ar.com.eduit.domain.dao.exceptions.GenericException;

public class ProductoDAOImpl implements ProductoDAO {
	
	private Connection connection;
	
	//contructor
	public ProductoDAOImpl() {
		try {
			this.connection = AdministradorDeConexiones.obtenerConexion();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Producto create(Producto producto) throws DuplicatedException, GenericException {
		
		String sqlCreate = "INSERT INTO productos (titulo, precio, codigo, tipo_producto) "
				+ "VALUES ('"+producto.getTitulo()+"', '"+producto.getPrecio()+"',  '"+producto.getCodigo()+"', '"+producto.getTipoProducto()+"');";
		
		try {
			PreparedStatement st = connection.prepareStatement(sqlCreate, PreparedStatement.RETURN_GENERATED_KEYS);
			
			st.execute();
			
			ResultSet rs = st.getGeneratedKeys();
			
			if(rs.next()) {
				Long pk = rs.getLong(1);
				producto.setId(pk);
			}
			
			return producto;
		} catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("Clave duplicada, no se ha registrado el producto", e);
			}
			throw new GenericException("No se ha podido crear el producto", e);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e);
			}
		}
	}

	@Override
	public Collection<Producto> findAll() throws GenericException {
		
		String sqlSelect = "SELECT * FROM PRODUCTOS";
		
		Collection<Producto> productos = new ArrayList<Producto>();
		
		try {
			PreparedStatement st = connection.prepareStatement(sqlSelect);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Long id = rs.getLong(1);// PK
				String titulo = rs.getString(2);
				Float precio = rs.getFloat(3);
				String codigo = rs.getString(4);
				Long tipoProducto = rs.getLong(5);
				
				Producto producto = new Producto(id, titulo, precio, codigo, tipoProducto);
				productos.add(producto);
			}
			
			return productos; 
		} catch (SQLException e) {
			throw new GenericException("No se ha podido crear el producto", e);
		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e);
			}
		}
	}
}
