package Div2R393;

import java.util.Scanner;

public class A {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int d = scan.nextInt();
		int odd = 7 - d + 1;
		int totalDays = 0;
		if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8|| m == 10 || m == 12){
			totalDays = 31;
		} else if ( m == 2) {
			totalDays = 28;
		} else{
			totalDays = 30;
		}
		int ans = 1;
		ans += (totalDays - odd)/7;
		if((totalDays -odd) % 7 != 0) ans++;
		System.out.println(ans);
	}
}
