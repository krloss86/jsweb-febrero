package ar.com.eduit.service.impl;

import java.util.Collection;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.domain.dao.ProductoDAO;
import ar.com.eduit.domain.dao.exceptions.DuplicatedException;
import ar.com.eduit.domain.dao.exceptions.GenericException;
import ar.com.eduit.domain.dao.exceptions.NonExistsException;
import ar.com.eduit.domain.dao.impl.ProductoDAOImpl;
import ar.com.eduit.exceptions.ServiceException;
import ar.com.eduit.service.ProductoService;

public class ProductoServiceImpl implements ProductoService {

	//uno o mas dao asociados
	private ProductoDAO dao;
	
	public ProductoServiceImpl() {
		//IOC, CDI
		dao = new ProductoDAOImpl();
	}

	@Override
	public Producto obtenerProducto(Long id) throws ServiceException{
		try {
			return this.dao.getById(id);
		} catch (GenericException e) {
			e.printStackTrace();
			throw new ServiceException("Error obteniendo el producto id="+id, e);
		}
	}

	@Override
	public Collection<Producto> obtenerTodos() throws ServiceException{
		
		try {
			return this.dao.findAll();
		} catch (GenericException e) {
			// log4j, logback, etc!
			e.printStackTrace();
			throw new ServiceException("Error obteniendo los productos", e);
		}
	}
	
	@Override
	public Producto eliminarProducto(String codigo) throws ServiceException {
		try {
			return this.dao.delete(codigo);
		} catch (GenericException | NonExistsException e) {
			throw new ServiceException("No se ha podido eliminar el producto", e);
		}		
	}
	
	@Override
	public Producto eliminarProducto(Long id) throws ServiceException {
		try {
			return this.dao.delete(id);
		} catch (GenericException | NonExistsException e) {
			throw new ServiceException("No se ha podido eliminar el producto", e);
		}		
	}
	
	@Override
	public Producto crearProducto(Producto nuevoProducto) throws ServiceException {
		try {
			return this.dao.create(nuevoProducto);
		} catch (DuplicatedException | GenericException e) {
			throw new ServiceException("No se ha podido crear el producto", e);
		}
	}
}
