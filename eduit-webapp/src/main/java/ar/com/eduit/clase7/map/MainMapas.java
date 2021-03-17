package ar.com.eduit.clase7.map;

import java.util.HashMap;
import java.util.Map;

public class MainMapas {

	public static void main(String[] args) {
		
		//CREA UN MAPA
		// Interface i = new Class()
		Map<Integer, String> diasDeSemana = new HashMap<>();

		//cargar una clave - valor
		diasDeSemana.put(1, "Lunes");
		diasDeSemana.put(2, "Martes");
		diasDeSemana.put(3, "Miercoles");
		diasDeSemana.put(4, "Jueves");
		diasDeSemana.put(5, "Viernes");
		diasDeSemana.put(6, "Sabado");
		diasDeSemana.put(7, "Domingo");
		diasDeSemana.put(8, "Domingo");//es posible usar claves distintas asociadas a los mismos valores
		
		System.out.println(diasDeSemana);
		
		//eliminar un elemento
		diasDeSemana.remove(2);
		
		System.out.println(diasDeSemana);
		
		//obtener un valor dado su clave
		String dia = diasDeSemana.get(3);
		
		System.out.println("Key:" + 3 + "value:" + dia);
		
		//remove por k y v
		diasDeSemana.remove(3, "Miercoles");//??
		
		System.out.println(diasDeSemana);
		
		//crear un mapa a partir de otro!
		Map<Integer, String> otroMapa = new HashMap<Integer, String>();
		otroMapa.putAll(diasDeSemana);
		
		System.out.println(otroMapa);
	}

}
