import java.util.*;
public class Calculator {
	public static int calculator(String str){
		int result=0;
		Stack<Character> s=new Stack<Character>();
		char[] arr= str.toCharArray();
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==' ')
				continue;
			if(arr[i]>='0' && arr[i]<='9')
				s.push(arr[i]);
			if(arr[i]=='+' || arr[i]=='-')
				s.push(arr[i]);
			if(arr[i]=='(')
				s.push(arr[i]);
			if(arr[i]==')')
			{
				List<Character> l=new ArrayList<Character>();
				while(s.peek()!='(');
				{
					l.add(s.peek());
					s.pop();
				}
				//s.push(.valueOf(miniCalculator(l)));
				result+=miniCalculator(l);
				
			}
		}
		return result;
	}
	
	public static int miniCalculator(List<Character> l){
		if(l.size()==1)
			return l.get(0);
		int a=Integer.valueOf(l.get(0));
		int b=Integer.valueOf(l.get(2));
		char op=l.get(1);
		switch(op)
		{
			case '+': 
				return a+b;
			case '-':
				return a-b;
			default:
				return 0;
		}
		
	}
}
