package ar.com.eduit.acciones;

import ar.com.eduit.domain.Producto;
import ar.com.eduit.exceptions.ServiceException;
import ar.com.eduit.interfaces.IAccion;
import ar.com.eduit.service.ProductoService;
import ar.com.eduit.service.impl.ProductoServiceImpl;

public class AltaAccion extends AccionBase implements IAccion {
	
	private ProductoService ps = new ProductoServiceImpl();
	
	@Override
	public void execute() throws ServiceException {
		
		System.out.println("Ingrese titulo: ");		
		String titulo = this.teclado.next();
		
		System.out.println("Ingrese codigo:");
		String codigo = this.teclado.next();
		
		System.out.println("Ingrese precio:");
		Float precio = this.teclado.nextFloat();
		
		System.out.println("Inese Tipo Producto");
		Long tipoProducto = this.teclado.nextLong();
		
		Producto nuevoProducto = new Producto(titulo, precio, codigo, tipoProducto);
		
		nuevoProducto = this.ps.crearProducto(nuevoProducto);
		System.out.println("Se ha creado el producto con id=" + nuevoProducto.getId());
	}

}
