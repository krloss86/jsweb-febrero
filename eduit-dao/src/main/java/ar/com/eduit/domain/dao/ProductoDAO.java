package ar.com.eduit.domain.dao;

import java.util.Collection;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.domain.dao.exceptions.DuplicatedException;
import ar.com.eduit.domain.dao.exceptions.GenericException;
import ar.com.eduit.domain.dao.exceptions.NonExistsException;

public interface ProductoDAO {

	/**
	 * INSERT INTO productos (titulo, codigo, tipo_producto) VALUES ('PEPE', '000003', '1');
	 * @param producto
	 * @return
	 * @throws GenericException 
	 * @throws DuplicatedException 
	 */
	public Producto create(Producto producto) throws DuplicatedException, GenericException;
	
	public Collection<Producto> findAll() throws GenericException;
	
	public Producto getById(Long id) throws GenericException;
	
	public Producto getByCode(String codigo) throws GenericException;
	
	public Collection<Producto> findAllByTitulo(String titulo) throws GenericException;
	
	public Producto update(Producto producto) throws DuplicatedException, GenericException;
	
	public Producto delete(Long id) throws GenericException, NonExistsException;
	
	public Producto delete(String codigo) throws GenericException, NonExistsException;
}
