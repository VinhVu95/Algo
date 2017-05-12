
public class KMP {
	public static int[] buildLps(String str){
		int length=str.length();
		int[] lps=new int[length];
		char[] a=str.toCharArray();
		lps[0]=0;
		for(int i=1;i<length;i++)
		{
			if(lps[i-1]!=0)
			{
				if(a[lps[i-1]]==a[i])
					lps[i]=lps[i-1]+1;
				else
					lps[i]=0;
			}
			else
			{
				if(a[0]==a[i])
					lps[i]=1;
				else
					lps[i]=0;
			}
		}
		return lps;
	}
	
	public static int indexMatching(String pattern,String text){
		int result=-1;
		int[] lps=buildLps(pattern);
		for(int i: lps){
			System.out.print(i + " ");
		}
		char[] t=text.toCharArray();
		char[] p=pattern.toCharArray();
		int j=0;
		for(int i=0;i<t.length;i++)
		{
			if(j<p.length && t[i]==p[j])
			{
				j++;
				continue;
			}
			else if(j<p.length && t[i]!=p[j])
				j=lps[j];
			if(j==p.length)
				return i-p.length;
		}
		return result;
	}
	
	public static void main(String[] args){
		String test="AnhVinhratdeptrai";
		String pattern="ABCDABCY";
		System.out.println(indexMatching(pattern,test));
	}
}
