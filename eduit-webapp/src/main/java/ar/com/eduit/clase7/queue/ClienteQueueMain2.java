package ar.com.eduit.clase7.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class ClienteQueueMain2 {

	public static void main(String[] args) {
				
		Queue<Cliente> clientes = new PriorityQueue<Cliente>( );

		clientes.offer(new Cliente(205l, "Juan", CategoriaEnum.CLASSIC));
		clientes.offer(new Cliente(100l, "Jose", CategoriaEnum.GOLD));		
		clientes.offer(new Cliente(51l, "Pepe", CategoriaEnum.PLATINUM));
		
		while(clientes.peek() != null ) {
			
			Cliente cliente = clientes.peek();
			
			System.out.println("Sigue:"+ cliente);
			
			clientes.poll();	
		}
		
	}

}
