import java.util.*;
public class JumpGame {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=scan.nextInt();
		System.out.println(canJump(a));
	}
	public static boolean canJump(int[] a){
		int i=0;
		boolean result=false;
		while(i<a.length)
		{
			if(i==a.length-1)
				result=true;
			if(a[i]==0 && i<a.length-1)
				return result;
			i=i+a[i];
		}
		return result;
	}
}
