/**
 * 
 */
package ar.com.eduit.parsers.enums;

/**
 * @author CHLopez
 *
 */
public enum FileEnum {

	CSV("csv");
	
	private String type;
	
	private FileEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
}
