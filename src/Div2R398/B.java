package Div2R398;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		long ts = scan.nextInt();
		long tf = scan.nextInt();
		long t = scan.nextInt();
		int n = scan.nextInt();
		long[] v = new long[n];
		long[] served = new long[n];
		for(int i = 0; i < n; i++){
			v[i] = scan.nextInt();
		}
		served[0] = ts;
		for(int i = 1; i < n; i++){
			served[i] = served[i-1] + t; 
		}
		long ans;
		for(int i = 0; i < n; i++){
			if(served[i] < v[i])
				ans = served[i];
		}
		
	}

}
