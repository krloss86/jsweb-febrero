package ar.com.eduit.web.servlet.clase13;

import java.util.ArrayList;
import java.util.List;

public class StreamMain {

	public static void main(String[] args) {
		
		List<Integer> edades = new ArrayList<Integer>();
		
		// filtre las edades > 20
		// edad - x
		
		List<Integer> edadesFiltradas = new ArrayList<Integer>();
		
		Integer filtro = 20;
		//que y como
		for(Integer edad : edades ) {
			if(edad > filtro) {
				edadesFiltradas.add(edad);				
			}
		}
		System.out.println(edadesFiltradas);
		
		List<String> edadesString = new ArrayList<String>();
		for(Integer edad : edadesFiltradas) {
			edadesString.add("edad - " + edad);
		}
		
		System.out.println(edadesString);

	}

}
