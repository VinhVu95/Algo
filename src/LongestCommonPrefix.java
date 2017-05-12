
public class LongestCommonPrefix {
	public static void main(String[] args){
		String[] strs=new String[3];
		strs[0]="abc";
		strs[1]="abcdef";
		strs[2]="abcfgr";
		System.out.println(longestCommonPrefix(strs));
	}
	public static String longestCommonPrefix(String[] strs){
		String result="";
		String minStr="";
		int minLength=Integer.MAX_VALUE;
		for(String str: strs){
			if(str.length()<minLength)
				{
					minLength=str.length();
					minStr=str;
				}
		}
		int end=-1;
		boolean flag=true;
		for(int i=0;i<minLength;i++)
		{
			char c= minStr.charAt(i);
			for(String str:strs)
			{
				if(str.charAt(i)!=c)
				{
					flag=false;
					break;
				}
			}
			if(flag==false)
				break;
			else
				end++;
		}
		if(end!=-1)
			result=minStr.substring(0, end+1);
		return result;
	}
}
