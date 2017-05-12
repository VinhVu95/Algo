package quantcast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReferenceCell extends Token {
	public static final String refPatternRegex = "([a-zA-Z]+)(\\d+)";
	
	private static final Pattern refPattern = Pattern.compile(refPatternRegex);
	
	private int refRow;
	private int refCol;
	
	public ReferenceCell(String str){
		setToken(str);
		Matcher matcher =  refPattern.matcher(str);
		
		if (matcher.matches()) {
			refRow = Utils.getRowIndex(matcher.group(1));
			refCol = Utils.getColIndex(matcher.group(2));
		} else {
			throw new RuntimeException("Error: Unable to parse reference: " + str);
		}
	}
	
	public int getRefRow() {
		return refRow;
	}
	
	public int getRefCol() {
		return refCol;
	}
}
