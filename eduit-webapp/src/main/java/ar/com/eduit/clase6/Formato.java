package ar.com.eduit.clase6;

public enum Formato {

	CSV,//0
	XLS,//1//alt+shit+r
	PDF;//2
	
	public static Formato getFormatoByString(String formatoBuscado) {
		Formato formato;
		try {
			formato = Formato.valueOf(formatoBuscado);
		}catch (RuntimeException e) {
			formato = null;
		}
		return formato;
	}
}
