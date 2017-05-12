import java.util.Scanner;

public class MaxNondecreaseSub {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int result=0;
		int[] arr=new int[n];
		int[] f=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=scan.nextInt();
		f[0]=1;
		for(int i=1;i<n;i++)
			{
				if(arr[i]>=arr[i-1])
					f[i]=f[i-1]+1;
				else
					f[i]=1;
			}
		for(int i=0;i<n;i++)
			result=Math.max(result, f[i]);
		System.out.println(result);
		scan.close();
	}
}
