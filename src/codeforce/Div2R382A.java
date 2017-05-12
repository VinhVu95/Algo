package codeforce;

import java.util.Scanner;

public class Div2R382A {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		scan.nextLine();
		String in = scan.next();
		char[] cells = in.toCharArray(); 
		int pos = 0;
		for(int i = 0; i < n; i++){
			if(cells[i] == 'G'){pos = i; break;}
		}
		int h = pos;
		int t = pos;
		boolean ans = false;
		while(h >= 0){
			if(cells[h] =='T') {ans = true; break;}
			if(cells[h] == '#') break;
			h -= k;
		}
		while(t < n){
			if(cells[t] == 'T'){ans = true;break;}
			if(cells[t] == '#') break;
			t += k;
		}
		if(ans) System.out.println("YES");
		else System.out.println("NO");
	}
}
