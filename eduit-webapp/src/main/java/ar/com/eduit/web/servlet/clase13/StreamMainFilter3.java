package ar.com.eduit.web.servlet.clase13;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMainFilter3 {

	public static void main(String[] args) {
		
		//obtener la suma de las edades
		List<Integer> edades = new ArrayList<Integer>();
		
		edades.add(20);
		edades.add(25);
		edades.add(27);
		edades.add(30);
		edades.add(22);
		edades.add(27);
		
		//operacion terminal de suma
		Optional<Integer> edad27 = edades
				.stream()
				.filter(x -> x ==35)
				.findFirst();
		
		//Optional me permite evitar NULL check -> NullPointerException
		if(edad27.isPresent()) {
			System.out.println(edad27.get());
		}else {
			System.err.println("No existe 35");
		}
	}

}
