
public class LongestCommonSubstring {
	public static void main(String[] args){
		String s1="ThisIsATestStr2ing";
		String s2="ThisIsANonTestString";
		System.out.println(longestCommonSubstring(s1, s2));
	}
	public static int longestCommonSubstring(String str1, String str2){
		char[] arr1=str1.toCharArray();
		char[] arr2=str2.toCharArray();
		int[][] l=new int[arr1.length][arr2.length];
		int result=0;
		if(arr1[0]==arr2[0])
			l[0][0]=1;
		if(arr1[0]==arr2[1])
			l[0][1]=1;
		if(arr1[1]==arr2[0])
			l[1][0]=1;
		for(int i=1;i<arr1.length;i++)
			for(int j=1;j<arr2.length;j++)
			{
				if(arr1[i]==arr2[j])
					l[i][j]=l[i-1][j-1]+1;
				else
					l[i][j]=0;
				result=Math.max(result, l[i][j]);
			}
		return result;
	}
}
