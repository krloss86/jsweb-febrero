package ar.com.eduit.clase6.collections.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetMain {

	public static void main(String[] args) {
		
		// Hashset el orden no mantiene 

		//crear
		Set<Integer> edades = new LinkedHashSet<Integer>();
		
		edades.add(20);
		edades.add(10);
		
		for (Integer edad : edades) {
			System.out.println(edad);
		}
		
		//practiar!!
	}

}
