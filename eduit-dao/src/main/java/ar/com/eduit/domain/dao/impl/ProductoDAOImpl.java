package ar.com.eduit.domain.dao.impl;

//JDBC
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
//jdbc
import java.util.Collection;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.domain.dao.AdministradorDeConexiones;
import ar.com.eduit.domain.dao.ProductoDAO;
import ar.com.eduit.domain.dao.exceptions.DuplicatedException;
import ar.com.eduit.domain.dao.exceptions.GenericException;
import ar.com.eduit.domain.dao.exceptions.NonExistsException;

public class ProductoDAOImpl implements ProductoDAO {
	
	//esto pasa a ser un objeto sin estado
	//private Connection connection;
	
	//contructor
	public ProductoDAOImpl() {
		/*
		try {
			this.connection = AdministradorDeConexiones.obtenerConexion();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		*/
	}

	private Connection getCurrentConnection() throws GenericException{
		try {
			return AdministradorDeConexiones.obtenerConexion();
		} catch (Exception e) {
			throw new GenericException("No se ha podido obtener una conexion",e);
		}
	}
	
	@Override
	public Producto create(Producto producto) throws DuplicatedException, GenericException {
		
		String sqlCreate = "INSERT INTO productos (titulo, precio, codigo, tipo_producto) "
				+ "VALUES ('"+producto.getTitulo()+"', '"+producto.getPrecio()+"',  '"+producto.getCodigo()+"', '"+producto.getTipoProducto()+"');";
		
		Connection connection = getCurrentConnection();
		
		try {
			
			connection.setAutoCommit(false);
			
			PreparedStatement st = connection.prepareStatement(sqlCreate, PreparedStatement.RETURN_GENERATED_KEYS);
			
			st.execute();
			
			ResultSet rs = st.getGeneratedKeys();
			
			if(rs.next()) {
				Long pk = rs.getLong(1);
				producto.setId(pk);
			}
			
			//mas logica
			/*if(true) {
				throw new SQLException("Error para hacer rollback");
			}*/
			
			connection.commit();
			
			return producto;
		} catch (SQLException e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				throw new GenericException("No se ha podido hacer rollbak de la transaccion", e);
			}
			
			if(e instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("Clave duplicada, no se ha registrado el producto", e);
			}
			throw new GenericException("No se ha podido crear el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e);
			}
		}
	}

	@Override
	public Collection<Producto> findAll() throws GenericException {
		
		String sqlSelect = "SELECT * FROM PRODUCTOS";
		
		Collection<Producto> productos = new ArrayList<Producto>();
		
		Connection connection = getCurrentConnection();
		
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
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e);
			}
		}
	}

	@Override
	public Producto getById(Long id) throws GenericException {
		
		String sqlSelect = "SELECT * FROM PRODUCTOS WHERE ID=" + id;
		
		Producto producto = null;
		
		Connection connection = getCurrentConnection();
		
		try {
			
			PreparedStatement st = connection.prepareStatement(sqlSelect);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Long pk = rs.getLong(1);// PK
				String titulo = rs.getString(2);
				Float precio = rs.getFloat(3);
				String codigo = rs.getString(4);
				Long tipoProducto = rs.getLong(5);
				
				producto = new Producto(pk, titulo, precio, codigo, tipoProducto);
			}
			
			return producto; 
		} catch (SQLException e) {
			throw new GenericException("No se ha podido crear el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e);
			}
		}
	}

	@Override
	public Producto getByCode(String codigo) throws GenericException {
		String sqlSelect = "SELECT * FROM PRODUCTOS WHERE codigo=" + codigo;
		
		Producto producto = null;
		
		Connection connection = getCurrentConnection();
		
		try {
			
			PreparedStatement st = connection.prepareStatement(sqlSelect);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Long pk = rs.getLong(1);// PK
				String titulo = rs.getString(2);
				Float precio = rs.getFloat(3);
				String code = rs.getString(4);
				Long tipoProducto = rs.getLong(5);
				
				producto = new Producto(pk, titulo, precio, code, tipoProducto);
			}
			
			return producto; 
		} catch (SQLException e) {
			throw new GenericException("No se ha podido crear el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e);
			}
		}
	}

	@Override
	public Collection<Producto> findAllByTitulo(String titulo) throws GenericException {
		
		StringBuffer sqlSelect = new StringBuffer("SELECT * FROM PRODUCTOS WHERE UPPER(TITULO) like '%"+titulo.toUpperCase()+"%'");
		
		Collection<Producto> productos = new ArrayList<Producto>();
		
		Connection connection = getCurrentConnection();
		
		try {
			PreparedStatement st = connection.prepareStatement(sqlSelect.toString());
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Long id = rs.getLong(1);// PK
				String title = rs.getString(2);
				Float precio = rs.getFloat(3);
				String codigo = rs.getString(4);
				Long tipoProducto = rs.getLong(5);
				
				Producto producto = new Producto(id, title, precio, codigo, tipoProducto);
				productos.add(producto);
			}
			
			return productos; 
		} catch (SQLException e) {
			throw new GenericException("No se ha podido crear el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e);
			}
		}		
	}

	@Override
	public Producto update(Producto producto) throws DuplicatedException, GenericException {
		
		Producto productoBuscado = this.getById(producto.getId());
		
		if(productoBuscado == null) {
			throw new GenericException("No existe el producto id="+ producto.getId(),null);
		}
		
		//actualizamos los datos de la base con el que viene en producto
		
		//precio
		productoBuscado.setPrecio(producto.getPrecio());
		productoBuscado.setTipoProducto(producto.getTipoProducto());
		productoBuscado.setTitulo(producto.getTitulo());
		productoBuscado.setCodigo(producto.getCodigo());//duplicated exception
		
		//armar sql 
		
		String sql = "UPDATE productos SET precio = ?, tipo_producto = ?, titulo = ?, codigo = ? WHERE ID = ?"; 
		
		Connection connection = getCurrentConnection();
		
		try {
			connection.setAutoCommit(false);
			
			PreparedStatement pst = connection.prepareStatement(sql);
			
			//setear en cada ? el valor correspondiente
			pst.setFloat(1, productoBuscado.getPrecio());
			pst.setLong(2, productoBuscado.getTipoProducto());
			pst.setString(3, productoBuscado.getTitulo());
			pst.setString(4, productoBuscado.getCodigo());
			pst.setLong(5, productoBuscado.getId());
			
			int resultado = pst.executeUpdate();
			if(resultado < 0) {
				throw new GenericException("No se ha actualizado el producto", null);
			}
			
			connection.commit();
		}catch (Exception e) {
			throw new GenericException("No se ha podido actualizar el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e);
			}
		}
		
		return productoBuscado;
	}
	
	@Override
	public Producto delete(Long id) throws NonExistsException, GenericException {
		
		Producto producto = this.getById(id);
		
		if(producto == null) {
			throw new NonExistsException("EL producto id="+ id +" no existe");
		}
		
		String sql = "DELETE FROM PRODUCTOS WHERE ID = ?";
		
		Connection connection = this.getCurrentConnection();
		
		try {
			
			connection.setAutoCommit(false);

			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setLong(1, id);
			
			int resultado = pst.executeUpdate();
			
			if(resultado < 0) {
				throw new GenericException("No se ha podido eliminar el Producto", null);
			}
			
			connection.commit();
			
			return producto;
		} catch (SQLException e) {
			throw new GenericException("No se ha podido eliminar el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e);
			}
		}
	}
	
	@Override
	public Producto delete(String codigo) throws GenericException, NonExistsException {
		Producto producto = this.getByCode(codigo);
		
		if(producto == null) {
			throw new NonExistsException("EL producto codigo="+ codigo +" no existe");
		}
		
		String sql = "DELETE FROM PRODUCTOS WHERE CODIGO = ?";
		
		Connection connection = this.getCurrentConnection();
		
		try {
			
			connection.setAutoCommit(false);

			PreparedStatement pst = connection.prepareStatement(sql);
			
			pst.setString(1, codigo);
			
			int resultado = pst.executeUpdate();
			
			if(resultado < 0) {
				throw new GenericException("No se ha podido eliminar el Producto", null);
			}
			
			connection.commit();
			
			return producto;
		} catch (SQLException e) {
			throw new GenericException("No se ha podido eliminar el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e);
			}
		}
	}
}
