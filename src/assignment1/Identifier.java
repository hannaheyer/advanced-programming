package assignment1;

public class Identifier implements IdentifierInterface {

	public static final String DEFAULT_NAME = "a";

	private StringBuffer identifier;

	public Identifier() {
		identifier = new StringBuffer();
	}

	public Identifier(Identifier identifier) {
		identifier = new StringBuffer();
		identifier.append(src.getChar());
	}

	}
	
	public void addChar(String x){
		identifier.append(x);
		return;
	}
	public String getChar(){
		return identifier.toString();
	}
	
	public int length() {
		return identifier.length();
	}

	public void init() {
		identifier = new StringBuffer();
	}
	
	public String print() {
		String print  = identifier.toString();
		return print;
	}
	

}