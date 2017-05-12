package ER17;

import java.util.Scanner;

public class C {
	public static void main(String[] args){ 
		Scanner scan = new Scanner(System.in);
		String in_a = scan.next();
		scan.nextLine();
		String in_b = scan.next();
		if(in_a.contains(in_b)) {
			System.out.println(in_b); return;
		}
		char[] a = in_a.toCharArray();
		char[] b = in_b.toCharArray();
		int la = a.length; int lb = b.length;
		int[] preb = new int[lb];
		int[] sufb = new int[lb];
		int j = 0;
		for(int i = 0; i < lb; i++){
			while(a[j++] != b[i]) {if(j >= la) { break;}}
			if(j< la) preb[i] = j;
			else {preb[i] = -1; while(++i < lb) preb[i] = -1;}
		}
		j = la - 1;
		for(int i = lb - 1; i >= 0; i--){
			while(a[j--] != b[i]){if(j < 0) break;}
			if(j >= 0) sufb[i] = j;
			else {sufb[i] = -1; while(--i >= 0) sufb[i] = -1;}
		}
		int l = 0; int r = 0;
		int min = lb;
		
		String remain = in_b;
		while(l < lb && r < lb){
			while(sufb[r] == -1 || sufb[r] <= preb[l]){
				r++;
				if(r >= lb) break; // code mo^~i 1 ba'i ma' ko xong
			}
			while(preb[l] != -1 && preb[l] < sufb[r]){
				l++; if(l >= lb) break;}
			l--;
			if(r - l - 1 < min) {min = r - l - 1; remain = in_b.substring(0, l + 1) + in_b.substring(r, lb);}
			if(preb[l++] == -1) {
				break;
			}
			
		}
		if(min == lb) {
			System.out.println("-");
		} else
			System.out.println(remain);
	}
}
