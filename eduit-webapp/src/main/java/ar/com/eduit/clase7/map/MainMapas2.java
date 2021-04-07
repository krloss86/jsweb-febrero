package ar.com.eduit.clase7.map;

import java.util.Map;

import ar.com.eduit.clase6.Formato;
import ar.com.eduit.clase6.IConvertible;

public class MainMapas2 {

	public static void main(String[] args) {
		
		System.out.println("Ingrese el formato a exportar");
		
		String formatoSeleccionado = "CSV";
		
		Formato formatoEnum = Formato.getFormatoByString(formatoSeleccionado);
		
		if(formatoEnum != null) {
			
			Map<Formato,IConvertible> map = CreadorConvertibles.contruirConvertibles();
			
			IConvertible fomatoIConvertible = map.get(formatoEnum);
			
			String conversion = fomatoIConvertible.convertir();
		}
	}

}
