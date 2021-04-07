package ar.com.eduit.web.servlet.clase13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMainFilter2 {

	public static void main(String[] args) {
		
		List<Integer> edades = new ArrayList<Integer>();
		
		edades.add(20);
		edades.add(25);
		edades.add(30);
		
		List<String> edadesFiltradas = edades
				.stream()
				.filter(x -> x > 25)//operacion intermedia
				.map(x-> new String("edad - " + x) )	//cambia de tipo de datos			
				.collect(Collectors.toList());//operacion terminal SUMA numérica
		
		System.out.println(edadesFiltradas);
	}

}
