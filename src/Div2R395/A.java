package Div2R395;

import java.util.Scanner;

public class A {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int z = scan.nextInt();
		int ans = 0;
		for(int i = 1; i <= z; i++){
			if(i%n == 0 && i%m == 0) ans++;
		}
		System.out.println(ans);
	}
}
