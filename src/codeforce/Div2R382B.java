package codeforce;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Div2R382B {
	//static DecimalFormat df = new DecimalFormat("#.########");
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		long[] w = new long[n];
		for(int i = 0; i < n; i++){
			w[i] = (long)scan.nextInt();
		}
		Arrays.sort(w);
		int a = Math.max(n1,n2);
		int b = Math.min(n1,n2);
		long first = 0, sec = 0;
		for(int i = n - a - b; i < n - b; i++) first += w[i];
		for(int i = n - b; i < n; i++) sec += w[i];
		double res = (double)first/(double) a + (double)sec/(double) b;
		System.out.printf("%.8f", res);
	}
}
