package ar.com.eduit.clase7.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ar.com.eduit.clase6.Formato;
import ar.com.eduit.clase6.IConvertible;

public class MainMapas4 {

	public static void main(String[] args) {
		
		Map<Formato,IConvertible> map = CreadorConvertibles.contruirConvertibles();
		
		Set<Map.Entry<Formato, IConvertible>> entries = map.entrySet();
		
		Iterator<Map.Entry<Formato, IConvertible>> itEntries = entries.iterator();
		
		while(itEntries.hasNext()) {
			Map.Entry<Formato, IConvertible> entry = itEntries.next();
			System.out.println(entry);
		}
	}

}
