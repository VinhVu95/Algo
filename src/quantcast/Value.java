package quantcast;

public class Value extends Token {
	
	public static final String patternRegex = "[+-]?\\d+";
	
	public Value(String str)
	{
		setToken(str);
	}
	
	public double getParsedValue(){
		return Double.parseDouble(getToken());
	}
}
