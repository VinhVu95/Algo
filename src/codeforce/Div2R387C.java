package codeforce;

import java.util.ArrayList;
import java.util.Scanner;

public class Div2R387C {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int q = scan.nextInt();
		int[] avail = new int[n];
		for(int i = 0; i < n; i++)
			avail[i] = 1;
		for(int i = 0; i < q; i++){
			int t = scan.nextInt();
			int k = scan.nextInt();
			int d = scan.nextInt();
			java.util.List<Integer> server = new ArrayList<Integer>();
			for(int j = 0; j < n; j++){
				if(avail[j] <= t){
					k--;
					server.add(j);
					if(k == 0) break;
					
				}
			}
			if(k != 0){
				System.out.println(-1);
			} else{
				int ans = 0;
				for(int s: server){
					avail[s] = (t + d);
					ans += (s + 1);
				}
				System.out.println(ans);
				
			}
		}
	}
}
