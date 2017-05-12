import java.util.*;
public class ValidParentheses {
	public static void main(String[] args){
		String s="(){{}[]}";
		System.out.println(isValid(s));
	}
	public static boolean isValid(String str){
		Map<Character,Character> m=new HashMap<Character,Character>();
		m.put('{', '}');
		m.put('(',')');
		m.put('[', ']');
		Stack<Character> s=new Stack<Character>();
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			if(m.keySet().contains(c))
				s.push(c);
			else if(m.values().contains(c))
			{
				if(!s.isEmpty() && m.get(s.peek())==c)
				{
					s.pop();
				}
				else
					return false;
			}
		}
		return true;
	}
}
