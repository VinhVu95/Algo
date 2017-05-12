package codeforce;

import java.util.Scanner;

public class Div12R397C {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		int a = scan.nextInt();
		int b = scan.nextInt();
		int a1 = a/k, a2 = a%k;
		int b1 = b/k, b2 = b%k;
		int res = 0;
		if((a1 == 0 && b1 > 0 && b2 != 0) || (b1 == 0 && a1 > 0 && a2 != 0)){
			res = -1;
		} else if(a1+b1 == 0){
			res = -1;
		} else {
			res = a1+ b1;
		}
		System.out.println(res);
	}
}
