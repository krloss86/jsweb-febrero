package ar.com.eduit.web.servlet.clase13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMainFilter4 {

	public static void main(String[] args) {
		
		//obtener la suma de las edades
		List<Integer> edades = new ArrayList<Integer>();
		
		edades.add(20);
		edades.add(25);
		edades.add(30);
		
		//operacion terminal de suma
		Integer sumaEdadesFiltradas = edades
				.stream()
				.filter(x -> x >= 25)//operacion intermedia
				.reduce(0, (x,y) -> x+y);
		
		System.out.println(sumaEdadesFiltradas);
	}

}
