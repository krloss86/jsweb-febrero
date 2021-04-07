package ar.com.eduit.clase6;

public class ArchivoCSV 
	extends ArchivoBase 
		implements IConvertible {

	public String convertir() {
		
		//titulo; otrotitulo; etc
		//abc,cde;efg; etc
		StringBuffer csv = new StringBuffer();
		
		csv.append("nombre;").append("\n");
		csv.append(this.nombre);
		
		String resultado = csv.toString();
		
		return resultado;
	}

}
