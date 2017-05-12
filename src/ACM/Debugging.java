package ACM;

import java.util.*;

public class Debugging {
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int r = scan.nextInt();
		int p = scan.nextInt();
		int[] memo = new int[n+1];
		int res = worseCaseDebug(n,r,p,memo);
		System.out.println(res);
	}	
	
	public static int worseCaseDebug(int n,int r,int p,int[] memo){
		if(n==1)
			return 0;
		int min = 10000000;
		for(int k=1;k < n;k++)
		{
			int m = (int) Math.ceil((double)n/(k+1));
			if(memo[m] == 0)
			{
				memo[m] = worseCaseDebug(m, r, p, memo);
			}
			min = Math.min(min, memo[m] + p*k)	;
		}
		return min + r;
	}
	
	
}
