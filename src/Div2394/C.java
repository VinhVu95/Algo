package Div2394;

import java.util.Arrays;
import java.util.Scanner;


public class C {
	static int n,m,ans,a,b,c;
	static int[][] mm=new int[100][10];
	static char[][] s=new char[100][];

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();m=in.nextInt();
		for(int i=1;i<=n;i++)
			s[i]=in.next().toCharArray();
		for(int i=1;i<=n;i++)
			Arrays.fill(mm[i],10000);
		for(int id=1;id<=n;id++)
		{
			int ch;
			for(int i=0;i<m;i++)
			{
				ch=s[id][i];a=Math.min(i,m-i);
				if('0'<=ch&&ch<='9') mm[id][1]=Math.min(mm[id][1],a);
				else if('a'<=ch&&ch<='z') mm[id][2]=Math.min(mm[id][2],a);
				else if(ch=='#'||ch=='*'||ch=='&') mm[id][3]=Math.min(mm[id][3],a);
			}
		}
		ans=10000;
		for(int i=1;i<=n;i++)
		for(int j=1;j<=n;j++)
		for(int k=1;k<=n;k++)
		{
			if(i==j||i==k||j==k) continue;
			ans=Math.min(ans,mm[i][1]+mm[j][2]+mm[k][3]);
		}
		System.out.println(ans);
	}
}
