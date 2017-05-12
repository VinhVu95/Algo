package quantcast;

import java.util.LinkedList;

public class Cell {
	private final int row;
	private final int col;
	private final String content;
	private final LinkedList<ReferenceCell> ref;
	private final LinkedList<Token> tokenList;
	private int unresolvedRefs;
	private boolean evaluated;
	private double value;
	
	public LinkedList<Token> getTokenList() {
		return tokenList;
	}
	
	public double getValue() {
		return value;
	}

	public int getUnresolvedRefs() {
		return unresolvedRefs;
	}

	public void setUnresolvedRefs(int unresolvedRefs) {
		this.unresolvedRefs = unresolvedRefs;
	}

	public void setValue(double value) {
		this.value = value;
	}


	public Cell(int row,int col,String content) {
		this.row= row;
		this.col= col;
		this.content = content;
		this.ref = new LinkedList<ReferenceCell>();
		tokenList = new LinkedList<Token>();
		this.unresolvedRefs = 0;
	}
	 
	
	public boolean isEvaluated() {
		return evaluated;
	}


	public void setEvaluated(boolean evaluated) {
		this.evaluated = evaluated;
	}


	public LinkedList<ReferenceCell> getReference(){
		return ref;
	}
	
	public String getContents(){
		return content;
	}
	
	public void parse(){
		String[] str = content.split("\\s+");
		for(String s: str)
		{
			Token token = makeToken(s);
			if(token.getClass().equals(ReferenceCell.class))
			{
				ref.add((ReferenceCell) token);
				unresolvedRefs++;
			}
			tokenList.add(token);
		}
	}
	
	private Token makeToken(String str) {
		if(Operator.isValidOperator(str))
			return new Operator(str);
		else if (str.matches(ReferenceCell.refPatternRegex))
			return new ReferenceCell(str);
		else if(str.matches(Value.patternRegex))
			return new Value(str);
		else
			return null;
	}
}
