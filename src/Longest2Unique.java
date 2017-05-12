import java.util.*;
import java.util.Map.Entry;
public class Longest2Unique {
	public static void main(String[] args){
		String test="abcbbbbcccbdddadacb";
		System.out.println(longest2Unique(test));
	}
	public static String longest2Unique(String s){
		if(s==null)
			return "";
		String result="";
		Map<Character,Integer> m=new HashMap<Character,Integer>();
		int start=0;
		int maxLen=0;
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(m.containsKey(c))
				m.put(c, m.get(c)+1);
			else
				m.put(c,1);
			while(m.size()>2)
			{
				char d=s.charAt(start);
				if(m.get(d)>1)
					m.put(d, m.get(d)-1);
				else
					m.remove(d);
				start++;
			}
			if(i-start+1>maxLen)
			{
				maxLen=i-start+1;
				result=s.substring(start, i+1);
			}
		}
		return result;
	}
}
