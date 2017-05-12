package codeforce;

import java.util.Scanner;

public class Div2R388B {
	static int[] x = new int[3];
	static int[] y  = new int[3];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 3; i++){
			x[i] = scan.nextInt();
			y[i] = scan.nextInt();
		}
		System.out.println(3);
		for(int i = 0; i < 3; i++){
			remainVertex(i);
		}
	}
	
	public static void remainVertex(int i){
		int xcenter = 0;
		int ycenter = 0;
		for(int j = 0; j < 3; j++){
			if(j != i) {xcenter += x[j]; ycenter += y[j];}
		}
		System.out.println((xcenter - x[i]) + " " + (ycenter - y[i]));
	}

}
