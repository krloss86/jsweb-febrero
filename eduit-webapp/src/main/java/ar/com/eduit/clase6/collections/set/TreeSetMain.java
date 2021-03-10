package ar.com.eduit.clase6.collections.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import ar.com.eduit.clase2.Persona;

public class TreeSetMain {

	public static void main(String[] args) {
		Set <String> edades = new TreeSet<>();
		
		edades.add("50");
		edades.add("30");
		edades.add("60");
		
		for(String edad : edades ) {
			System.out.println(edad);
		}
		
		//
		Set<Alumno> alumnos = new TreeSet<>();
		alumnos.add(new Alumno(75l, "Exequiel"));
		alumnos.add(new Alumno(15l, "Federico"));
		alumnos.add(new Alumno(75l, "Lucas"));
		
		for (Alumno alumno : alumnos) {
			System.out.println(alumno.getId());
			System.out.println(alumno.getNombre());
		}
		
	}

}
