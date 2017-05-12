package Div2394;

import java.util.Scanner;

public class B {
	static int n;
	static int L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		L = scan.nextInt();
		int[] disKef = new int[n];
		int[] disSas = new int[n];
		for(int i = 0; i < n; i++){
			disKef[i] = scan.nextInt();
		}
		for(int i = 0; i < n; i++){
			disSas[i] = scan.nextInt();
		}
		int[] a = checkPoints(disKef);
		int[] b = checkPoints(disSas);
		int j = 0;
		boolean ans = false;
		for(int i = 0; i < n; i++){
			int k = i;
			for(j = 0; j < n; j++){
				if(a[k] != b[j]) break;
				k++;
				if(k == n) k = 0;
			}
			if(j == n) ans = true;
		}
		if(ans) System.out.println("YES");
		else System.out.println("NO");
	}
	
	public static int[] checkPoints(int[] a){
		int[] res = new int[n];
		for(int i = 1; i < n; i++){
			res[i] = a[i] - a[i-1];
		}
		res[0] = L - a[n-1] + a[0];
		return res;
	}
	
	

}
