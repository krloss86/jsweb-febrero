package ar.com.eduit.clase6;

public class TipoMain {

	public static void main(String[] args) {
		
		// quiero ver el nombre de enum
		Formato tpdf = Formato.PDF;
		
		TiposValidos tv = new TiposValidos();
		tv.mostrarValorEnum(tpdf);
		
		Formato pcsv = Formato.CSV;
		tv.mostrarValorEnum(pcsv);
		
		Formato txls = Formato.XLS;		
		tv.mostrarValorEnum(txls);

		//recorrer todos los valores de enum definido en Formato
		Formato[] tipos = Formato.values();
		
		for(Formato tipo : tipos) {
			tv.mostrarValorEnum(tipo);
		}
	}

}
