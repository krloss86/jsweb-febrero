package ar.com.eduit.clase6;

public class MainConvertible {

	public static void main(String[] args) {
		
		String nombre = "VENTAS-2021";
		String formatoUsuario = "PDF"; // ->Formato.CSV

		Formato formatoValido = Formato.getFormatoByString(formatoUsuario);
		
		if(formatoValido != null) {
			System.out.println(formatoUsuario +" existe como enum");
		}else {
			System.err.println(formatoUsuario + " no es valido");
		}
		
		IConvertible p;
		if(Formato.PDF.equals(formatoValido)) {
			//crear la clase que convierte a pdf
			p = new ArchivoPDF();
		}else if(Formato.CSV.equals(formatoValido)){
			//crear la clase que convierte a csv
			p = new ArchivoCSV();
		} else {
			p = new ArchivoXLS();
			// crear la clase que convierte a xls
		}
		
		//casteo hacia arriba UpCasting
		((ArchivoBase)p).setNombre(nombre);
		
		String resultado = p.convertir();
		
		System.out.println(resultado);
	}

}
