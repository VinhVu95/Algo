package Div2R396;

import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long[] seg = new long[n];
		for(int i = 0; i < n; i++){
			seg[i] = scan.nextLong();
		}
		Arrays.sort(seg);
		for(int i = 2; i < n; i++){
			if(seg[i-2] + seg[i-1] > seg[i])
			{
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

}
