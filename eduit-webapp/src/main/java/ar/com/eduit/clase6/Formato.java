package ar.com.eduit.clase6;

public enum Formato {

	PDF,//0
	XLS,//1//alt+shit+r
	CSV;//2
	
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
