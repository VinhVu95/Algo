package Div2R396;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		scan.nextLine();
		String b = scan.next();
		if(a.length() != b.length())
			System.out.println(Math.max(a.length(), b.length()));
		else if(a.equals(b))
			System.out.println(-1);
		else
			System.out.println(a.length());
	}

}
