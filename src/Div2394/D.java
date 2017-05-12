package Div2394;

import java.util.Scanner;

public class D {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int l = scan.nextInt();
		int r = scan.nextInt();
		int[] a = new int[n];
		int[] p = new int[n];
		int[] b = new int[n];
		for(int i = 0; i < n; i++) a[i] = scan.nextInt();
		int max =  Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			p[i] = scan.nextInt(); 
			b[i] = a[i] + p[i];
			max = Math.max(max,b[i]); min = Math.min(min, b[i]);
		}
		if(min >= l && max <= r){
			print(b);
		} else if(min < l && max <= r){
			if(l - min < r - max){
				System.out.println(-1);
			} else {
				for(int i = 0 ; i < n; i++) b[i] = b[i] + (l - min);
				print(b);
			}
		} else if(l <= min && r < max){
			if(min - l < max - r){
				System.out.println(-1);
			} else{
				for(int i = 0; i < n; i++) b[i] = b[i] - (max - r);
				print(b);
			}
		} else if(min < l && max > r){
			System.out.println(-1);
		}
		
		
	}
	
	public static void print(int[] b){
		for(int num : b){
			System.out.print(num + " ");
		}
	}
}
