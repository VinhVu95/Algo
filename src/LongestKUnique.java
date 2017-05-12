import java.util.HashMap;
import java.util.Map;

public class LongestKUnique {
	public static void main(String[] args){
		String test="abcbbbbcccbdddadacbeebbcebbccebbbccceee";
		System.out.println(longest2Unique(test,3));
	}
	public static String longest2Unique(String s,int k){
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
			while(m.size()>k)
			{
				char d=s.charAt(start);
				if(m.get(d)>1)
					m.put(d, m.get(d)-1);
				else
					m.remove(d);
				start++;
			}
			if(m.size()==k){
				if(i-start+1>maxLen)
				{
					maxLen=i-start+1;
					result=s.substring(start, i+1);
				}
			}
			
		}
		if(m.size()==k && maxLen==0)
			return s;
		return result;
	}
}
