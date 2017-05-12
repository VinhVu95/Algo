package codepractice;

import java.util.*;

public class Schedule {
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=scan.nextInt();
		int count=0;
		int i=0;
		while(i<n)
		{
			if(arr[i]==1)
			{
				count++;
				i++;
			}
			else
			{
				if(i>0 && i<n-1 && arr[i-1]==1 && arr[i+1]==1)
					count++;
				i++;
			}
		}
		System.out.println(count);
		scan.close();
	}
}
