package ar.com.eduit.web.servlet.clase13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMainFilter {

	public static void main(String[] args) {
		
		List<Integer> edades = new ArrayList<Integer>();
		
		//filter 
		
//		java.util.stream -> Stream (ojo no es stream de archivos)

		edades.add(20);
		edades.add(25);
		edades.add(30);
		
		//> 20
		Stream<Integer> integerStream = edades.stream();
		
		//operacion intermedia
		integerStream = integerStream.filter(x -> x > 25); //iteracion interna de la implementación
		//integerStream = integerStream.filter(x -> x != 27);
		
		//collectors
		List<Integer> edadesFiltradas = integerStream.collect(Collectors.toList());
		
		System.out.println(edadesFiltradas);
	}

}
