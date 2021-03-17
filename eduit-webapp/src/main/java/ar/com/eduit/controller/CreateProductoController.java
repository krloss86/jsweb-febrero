package ar.com.eduit.controller;

import java.util.Collection;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.domain.dao.ProductoDAO;
import ar.com.eduit.domain.dao.exceptions.DuplicatedException;
import ar.com.eduit.domain.dao.exceptions.GenericException;
import ar.com.eduit.domain.dao.impl.ProductoDAOImpl;

public class CreateProductoController {

	public static void main(String[] args) {
		
		String titulo = "lg k50";
		Float precio = 30000f;
		String codigo = "000500";
		Long tipoProducto = 1L; //celulares
		
		Producto nuevoProducto = new Producto(titulo, precio, codigo, tipoProducto);
		
		//usar la interface que está en eduit-domain
		
		ProductoDAO pDao = new ProductoDAOImpl();
		try {
			nuevoProducto = pDao.create(nuevoProducto);
			
			System.out.println("Se ha creado el producto: id=" + nuevoProducto.getId());
			
			//pDao = new ProductoDAOImpl();
			
			//obtengo todos los productos
			Collection<Producto> todos = pDao.findAll();
			
			System.out.println(todos);
		} catch (DuplicatedException e) {
			System.err.println(e.getMessage());
			System.err.println(e.getCause().getMessage());
		} catch (GenericException e) {
			e.printStackTrace();
		}
	}
	
}
