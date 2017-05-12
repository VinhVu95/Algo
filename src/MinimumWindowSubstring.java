import java.util.*;
public class MinimumWindowSubstring {
	public static String minimumSubstring(String s,String t){
		if(t==null)
			return "";
		String result="";
		Map<Character,Integer> tSet= new HashMap<Character,Integer>();
		char[] tArr=t.toCharArray();
		for(Character c:tArr)
		{
			if(tSet.containsKey(c))
				tSet.put(c, tSet.get(c));
			else
				tSet.put(c, 1);
		}
		char[] sArr=s.toCharArray();
		Map<Character,Integer> sSet=new HashMap<Character,Integer>();
		int left=0;
		int minLen=s.length()+1;
		int count=0;
		for(int i=0;i<sArr.length;i++)
		{
			if(tSet.containsKey(sArr[i]))
			{
				if(sSet.containsKey(sArr[i]))
				{
					if(sSet.get(sArr[i])<tSet.get(tArr[i]))
						count++;
					sSet.put(sArr[i], sSet.get(sArr[i]));
				}
				else 
				{
					sSet.put(sArr[i], 1);
					count++;
				}
			}
			if(count==t.length())
			{
				char c=s.charAt(i);
				while(!sSet.containsKey(c)|| sSet.get(c)-tSet.get(c)>0 )
				{
					left++;
					if(sSet.get(c)>tSet.get(c) && sSet.containsKey(c))
						sSet.put(c, sSet.get(c)-1);
					c=s.charAt(left);
				}
				if(minLen<i-left+1)
				{
					minLen=i-left+1;
					result=s.substring(left,i+1);
				}
			}
		}
		return result;
	}
}
