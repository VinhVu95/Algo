package quantcast;

import java.util.Stack;

public class Operator extends Token {
	public Operator(String operator){
		setToken(operator);
	}
	
	public static boolean isValidOperator(String token){
		
		if(token == "+" || token == "-" || token == "*" || token == "/") {
			return true;
		}
		return false;
	}
	
	public static Stack<Double> apply(Stack<Double> RPN,String token) {
		double op1,op2;
		if(token.equals("+"))
		{
			op1 = RPN.pop();
			op2 = RPN.pop();
			RPN.push(op1+op2);
		} else if (token.equals("-"))
		{
			op1 = RPN.pop();
			op2 = RPN.pop();
			RPN.push(op2-op1);
		} else if( token.equals("*"))
		{
			op1 = RPN.pop();
			op2 = RPN.pop();
			RPN.push(op2*op1);
		} else if( token.equals("/"))
		{
			op1 = RPN.pop();
			op2 = RPN.pop();
			RPN.push(op2/op1);
		} else{
			throw new IllegalArgumentException("Wrong operator");
		}
		return RPN;
	}
}

