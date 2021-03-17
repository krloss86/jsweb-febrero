package ar.com.eduit.clase7.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ClienteQueueMain {

	public static void main(String[] args) {
		/*
		Set<Integer> edades = new HashSet<>();
		edades.add(10);
		edades.add(20);
		edades.add(30);
		
		for(Integer edad : edades) {			
			edades.remove(edad);
		}
		*/
		
		Queue<Cliente> clientes = new LinkedList<Cliente>();

		clientes.offer(new Cliente(100l, "Jose", CategoriaEnum.GOLD));		
		clientes.offer(new Cliente(205l, "Juan", CategoriaEnum.CLASSIC));
		clientes.offer(new Cliente(51l, "Pepe", CategoriaEnum.PLATINUM));
		
		System.out.println(clientes);
		
		int i = 2;
		while(!clientes.isEmpty()) {
			Cliente clienteAtendido = clientes.poll();
			System.out.println("Atendiendo a : " + clienteAtendido);
			
			System.out.println("Restan atender" +clientes);
			
			System.out.println("Nuevo cliente:");
			
			if(i==1)
				clientes.offer(new Cliente(303l, "Carlos", CategoriaEnum.SIGNATURE));
			i--;
		}
	}

}
