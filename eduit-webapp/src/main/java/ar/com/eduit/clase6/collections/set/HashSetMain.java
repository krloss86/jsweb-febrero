package ar.com.eduit.clase6.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import ar.com.eduit.clase6.ArchivoCSV;
import ar.com.eduit.clase6.ArchivoPDF;
import ar.com.eduit.clase6.ArchivoXLS;
import ar.com.eduit.clase6.IConvertible;

public class HashSetMain {

	public static void main(String[] args) {
		
		//crear: no mantienen un orden
		Set<Integer> edades = new HashSet<Integer>(); 

		//agregar elementos al set(HashSet>
		edades.add(10);
		edades.add(20);
		
		//cantidad de elemetnos guardados en el set
		int cantidad = edades.size();
		
		//recorrer
		for(Integer edad : edades) {
			edades.remove(edad);
		}
		
		//eliminar solo el 20
		// edades.remove(20);
		
		//----------------------
		Set<IConvertible> convertibles = new HashSet<IConvertible>();
		IConvertible p = new ArchivoPDF();
		
		//agregar
		convertibles.add(p);
		
		p = new ArchivoCSV();
		convertibles.add(p);
		
		p = new ArchivoXLS();
		convertibles.add(p);
		
		//recorrer e ir eliminando sus elementos de manera segura
		Iterator<IConvertible> itIConvertible = convertibles.iterator();
		while(itIConvertible.hasNext()) {
			IConvertible convertibleParticular = itIConvertible.next();
			String resultado = convertibleParticular.convertir();
			System.out.println(resultado);
			
			itIConvertible.remove();
		}
	}

}
