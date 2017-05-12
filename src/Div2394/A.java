package Div2394;

import java.util.Scanner;

public class A {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		if(Math.abs(a-b) <= 1 && (a != 0 || b != 0))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
