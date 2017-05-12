
public class LongestPalindromeSubsequence {
	public static int longestPalindrome(String str){
		int result=0;
		char[] a=str.toCharArray();
		int size=a.length;
		int[][] matrix=new int[size][size];
		for(int i=0;i<size;i++)
			matrix[i][i]=1;
		for(int l=2;l<size;l++)
			for(int i=0;i<size-l+1;i++)
			{
				int j=i+l-1;
				if(a[i]==a[j])
				{
					if(j==i+1)
						matrix[i][j]=2;
					else
						matrix[i][j] = matrix[i+1][j-1]+2;
				}
				else
					matrix[i][j]=Math.max(matrix[i+1][j], matrix[i][j-1]);
				result=Math.max(result, matrix[i][j]);
				
			}
		return result;
	}
}
