package ar.com.eduit.clase7.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MainMapas3 {

	public static void main(String[] args) {
		
		//CREA UN MAPA
		// Interface i = new Class()
		Map<Integer, String> diasDeSemana = new TreeMap<>();

		//cargar una clave - valor
		diasDeSemana.put(2, "Martes");
		diasDeSemana.put(4, "Jueves");
		diasDeSemana.put(1, "Lunes");
		diasDeSemana.put(6, "Sabado");
		diasDeSemana.put(3, "Miercoles");
		diasDeSemana.put(7, "Domingo");
		diasDeSemana.put(5, "Viernes");

		//obtengo todas las claves del mapa
		Set<Integer> keys = diasDeSemana.keySet();
		System.out.println("Claves del mapa");
		for(Integer key : keys) {
			System.out.println(key);
		}
		
		//obtener todos los Valores
		Collection<String> values = diasDeSemana.values();
		System.out.println("Valores del mapa");
		System.out.println(values);
		
		//sabiendo las claves (keySet) obtengo los valores
		System.out.println("sabiendo las claves (keySet) obtengo los valores");
		for(Integer key : keys) {
			String value = diasDeSemana.get(key);
			System.out.println("Key:" + key + "="+value);
		}
		
		//EntrySet
		Set<Map.Entry<Integer, String>> entries = diasDeSemana.entrySet();
		
		//for
		for( Map.Entry<Integer, String> entry : entries ) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println("Key:" + key + "="+value);
		}
	}

}
