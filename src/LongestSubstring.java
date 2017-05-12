
public class LongestSubstring {
	public static void main(String[] args){
		String test="abcabcbb";
		System.out.println(longgestSubstringLength(test));
	}
	public static int longgestSubstringLength(String str){
		if(str==null)
			return 0;
		int result=0;
		//int min_value=Integer.MIN_VALUE;
		int start=0;
		boolean[] m=new boolean[256];
		char[] a= str.toCharArray();
		for(int i=0;i< str.length();i++)
		{
			char c= a[i];
			if(!m[c])
				{
					m[c]=true;
				}
			else
			{	
				int k=start;
				result=Math.max(result,i-k);
				while(k<i)
				{	
					if(a[k]==a[i])
						{
							start=k+1;
							break;
						}
					k++;
				}
			}
		}
		return result;
	}
}
