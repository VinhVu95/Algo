package Div2R398;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] sizes = new int[n];
		int[] s = new int[n+1];
		for(int i = 0; i <n; i++){
			sizes[i] = scan.nextInt();
		}
		int next = n;
		for(int i = 0; i < n; i++){
			s[sizes[i]] = 1;
			while(s[next] == 1){
				System.out.print(next+ " ");
				next--;
			}
			System.out.println();
		}
	}

}
