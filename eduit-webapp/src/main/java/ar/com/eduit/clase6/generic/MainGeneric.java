package ar.com.eduit.clase6.generic;

public class MainGeneric {

	public static void main(String[] args) {
		
		//I = new C
		IFileParser<String> parser = new StringFileParser();
		
		String resultado = parser.convert();
		
		System.out.println(resultado);
		
		IFileParser<Long> parserLong = new LongFileParser();
		
		Long resultadoLong = parserLong.convert();
		
		System.out.println(resultadoLong);
	}

}
