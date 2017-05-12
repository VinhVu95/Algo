package codepractice;
import java.util.*;
public class HomeToShop {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int[] arr1=new int[n-1];
		int[] arr2=new int[n-1];
		int[] b=new int[n];
		for(int i=0;i<n-1;i++)
			arr1[i]=scan.nextInt();
		for(int i=0;i<n-1;i++)
			arr2[i]=scan.nextInt();
		for(int i=0;i<n;i++)
			b[i]=scan.nextInt();
		int[] p=new int[n];
		p[0]=b[0];
		for(int i=0;i<n-1;i++)
		{
			p[0]+=arr2[i];
		}
		for(int i=1;i<n;i++)
		{
			p[i]=p[i-1]-b[i-1]-arr2[i-1]+b[i]+arr1[i-1];
		}
		int t1=p[0];
		int t2=p[1];
		if(t1>t2)
		{
			int temp=t1;
			t1=t2;
			t2=temp;
		}
		for(int i=2;i<n;i++)
		{
			if(t1>p[i])
			{
				t2=t1;
				t1=p[i];
			}
			else
			{
				if(t2>p[i])
					t2=p[i];
			}
		}
		System.out.println(t1+t2);
		scan.close();
	}
}
