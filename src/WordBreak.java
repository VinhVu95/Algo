import java.util.*;

public class WordBreak {
	public static boolean wordBreak(Set<String> dict, String s){
		boolean[] t=new boolean[s.length()+1];
		t[0]=true;
		for(int i=0;i<s.length();i++)
		{
			if(!t[i])
				continue;
			for(String a:dict){
				int len=a.length();
				int end=len+i;
				if(end>s.length())
					continue;
				if(t[end])
					continue;
				if(s.substring(i,end).equals(a))
					t[end]=true;
			}
		}
		return t[s.length()];
	}
	
	public static void main(String[] args){
		String s="leetcodeisawesome";
		Set<String> dict=new HashSet<String>();
		dict.add("leet");
		dict.add("abc");
		dict.add("code");
		dict.add("awesome");
		dict.add("is");
		System.out.println(wordBreak(dict,s));
		
	}
}
