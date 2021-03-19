package ar.com.eduit.controller;

import java.util.Scanner;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.exceptions.ServiceException;
import ar.com.eduit.service.ProductoService;
import ar.com.eduit.service.impl.ProductoServiceImpl;

public class DeleteProductoController {

	public static void main(String[] args) {
		
		System.out.println("Ingrese el ID (EJ:1) a eliminar");
		
		Scanner teclado = new Scanner(System.in);		
		Long id = teclado.nextLong();

		ProductoService ps = new ProductoServiceImpl();
		Producto producto;
		try {
			producto = ps.eliminarProducto(id);
			System.out.println("Se ha eliminado el producto:");
			System.out.println(producto);
		} catch (ServiceException e) {
			e.printStackTrace();
		} finally {
			teclado.close();
		}
	}

}
