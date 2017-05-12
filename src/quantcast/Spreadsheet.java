package quantcast;

import java.util.Scanner;
import java.util.Stack;

import javax.management.RuntimeErrorException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Spreadsheet {
	public int n;
	public int m;
	public int unsolved;
	public Cell[][] workbook;
	private final HashMap<ReferenceCell, HashSet<Cell>> dependencyMap;
	private final LinkedList<Cell> topologicalList;
	boolean circularDependant;
	
	public Spreadsheet() {
		dependencyMap =  new HashMap<ReferenceCell,HashSet<Cell>>();
		topologicalList = new LinkedList<Cell>();
	}
	
	public static void main(String[] args)
	{
		Spreadsheet spreadsheet = new Spreadsheet();
		spreadsheet.readInput(new Scanner(System.in));
		spreadsheet.evaluate();
		if(spreadsheet.circularDependant) {
			String.format("The input include circular dependant");
		}
		else {
			spreadsheet.printSpreadSheet();
		}
	}
	
	public void readInput(Scanner scanner) {
		n = scanner.nextInt();
		m = scanner.nextInt();
		unsolved = n*m;
		scanner.nextLine();
		
		workbook = new Cell[m][n];
		
		for(int i = 0; i< m;i++)
		{
			for(int j = 0;j< n;j++)
			{
				String input = scanner.nextLine().trim().toUpperCase();
				workbook[i][j] = new Cell(i,j,input);
				Cell cur = workbook[i][j];
				if(cur.getReference().size() > 0){
					addToDependenciesMap(cur);
				} else {
					topologicalList.add(cur);
				}
					
			}
		}
		scanner.close();
	}
	
	
	public void addToDependenciesMap(Cell cell) {
		LinkedList<ReferenceCell> curCellDep = cell.getReference();
		for (ReferenceCell  token : curCellDep ) {
			HashSet<Cell> refBy;
			if (dependencyMap.containsKey(token))
			{
				 refBy = dependencyMap.get(token);
			} else {
				refBy = new HashSet<Cell>();
				dependencyMap.put(token,refBy);
			}
			refBy.add(cell);		
		}
		
	}
	
	/**
	 * function to evaluate a cell
	 * @param cur cell to evaluate
	 * @return 
	 */
	public double evaluate(Cell cur) {
		if(cur.isEvaluated())
			return cur.getValue();
		
		Stack<Double> RPN = new Stack<Double>();
		LinkedList<Token> curCellToken = cur.getTokenList();
		
		for(Token token: curCellToken)
		{
			if(token.getClass().equals(Value.class))
			{
				RPN.push(((Value) token).getParsedValue());
			} else if (token.getClass().equals(ReferenceCell.class)) {
				ReferenceCell ref = (ReferenceCell) token;
				Cell refCell = workbook[ref.getRefRow()][ref.getRefCol()];
				RPN.push(evaluate(refCell));
				System.out.println(evaluate(refCell));
			} else if (token.getClass().equals(Operator.class)) {
				Operator opTok = (Operator) token;
				RPN = Operator.apply(RPN, opTok.getToken());
			} else {
				throw new RuntimeException("Invalid token");
			}
		}
		cur.setEvaluated(true);
		cur.setValue(RPN.pop());
		return cur.getValue();
	}
	
	/**
	 * evaluate spreadsheet cell by cell in topological order
	 */
	public void evaluate() {
		while (topologicalList.size() > 0){
			Cell cur = topologicalList.removeFirst();
			evaluate(cur);
			unsolved--;
			resolveDependencies(cur);
		}
		if(unsolved != 0){
			circularDependant = true;
		}
	}
	
	/**
	 * Get all cells dependent on this cell
	 * If the depended cell has no more unresolved reference, evaluate this cell and add to topological list
	 */
	private void resolveDependencies(Cell cur){
		if(dependencyMap.containsKey(cur)) {
			HashSet<Cell> curCellDeps = dependencyMap.get(cur);
			if(curCellDeps.size() > 0) {
				for(Cell depCell : curCellDeps) {
					depCell.setUnresolvedRefs(depCell.getUnresolvedRefs() - 1);
					if(depCell.getUnresolvedRefs() == 0)
						topologicalList.add(depCell);				
				}
			}
		}
	}
	
	public String printSpreadSheet() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m;i++) {
			for(int j = 0;j < n;j++) {
				if (workbook[i][j].isEvaluated()) {
					String value = String.format("%.5f", workbook[i][j].getValue());
					sb.append(value);
				} else {
					sb.append("Not evaluated");
				}
				if(!(i == m - 1 && j == n - 1))
					sb.append(System.lineSeparator());
				
			}
		}
		return sb.toString();
	}
	

}
