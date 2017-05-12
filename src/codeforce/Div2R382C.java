package codeforce;

import java.util.Scanner;

public class Div2R382C {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		long n = scan.nextInt();
		long m = n;
		long ans1 = 0;
		long ans2 = 0;
		while(n > 1){
			if(n == 2){
				ans1++; break;
			}
			ans1 += 2;
			if(n%3 == 2) n = n/3 + 1;
			else n= n/3;
		}
		while( m > 1){
			if(m%2 == 1) ans2 += 2;
			else ans2 ++;
			m = m/2;
		}
		System.out.println(Math.max(ans2,ans1));
	}
}
