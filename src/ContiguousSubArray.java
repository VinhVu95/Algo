import java.util.Scanner;

public class ContiguousSubArray {
	public static int largestSum(int[] a){
		int size=a.length;
		int[] c=new int[size];
		c[0]=a[0];
		for(int i=1;i<size;i++)
		{
			c[i]=a[i];
			if(c[i]<c[i-1]+a[i])
				c[i]=c[i-1]+a[i];
		}
		int result=c[0];
		for(int i:c)
		{
			result=Math.max(result, i);
		}
		return result;
	}
	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=scan.nextInt();
		System.out.println(largestSum(a));
	}
}
