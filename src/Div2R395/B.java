package Div2R395;

import java.util.Scanner;

public class B {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n+1];
		for(int i = 1; i <= n; i++){
			a[i] = scan.nextInt();
		}
		int c = 1;
		int temp = 0;
		for(int i = 1; i <= n - i; i++){
			if(c % 2 == 1) {
				temp = a[i];
				a[i] = a[n - i + 1];
				a[n-i+1] = temp;
			}
			c++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n;i++){
			sb.append(a[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}
