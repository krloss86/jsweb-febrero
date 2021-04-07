package ar.com.eduit.clase6;

public class ArchivoXLS extends ArchivoBase implements IConvertible {

	@Override
	public String convertir() {		
		return this.nombre +".xls";
	}

}
