package codeforce;

import java.util.Scanner;

public class Div2R388C {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		String in = scan.next();
		char[] votes = in.toCharArray();
		boolean[] banned = new boolean[n];
		int d = 0;
		int r = 0;
		for(char c: votes){
			if(c == 'D') d++;
			if(c == 'R') r++;
		}
		while(d != 0 && r != 0){
			int j = 0;
			int k = 0;
			while(j < n && k < n){
				if(banned[j]) j++;
				else{
					k = 0;
					while(k < n){
						if(votes[j] == votes[k] || banned[k]) k++;
						else {
							banned[k] = true;
							if(votes[k] == 'D') d--;
							else if(votes[k] == 'R') r--;
							j++;
							break;
						}
					}
				}
			}
		}
		if(d == 0) System.out.println('R');
		else if(r == 0) System.out.println('D');
	}
}
