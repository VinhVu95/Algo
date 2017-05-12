package codeforce;

import java.util.Scanner;

public class EightVCD {
	public static void main(String[] args){
		Scanner  scan = new Scanner(System.in);
		long n = scan.nextInt();
		long k = scan.nextInt();
		if(k > n / 2){
			k = n - k;
		}
		long ans = 1;
		long cut = 1;
		long i = 1;
		StringBuilder sb= new StringBuilder();
		for(long j = 0; j < n;j++){
			if(i < n && i + k <= n+1){
				ans += cut;
				i += k;
			} else if(i + k > n + 1){
				ans += (cut +1);
				cut += 2;
				i = (i+k) - n;
			}
			sb.append(ans).append(" ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
	
}
