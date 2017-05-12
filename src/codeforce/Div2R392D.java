package codeforce;

import java.util.Scanner;

public class Div2R392D {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		String in = scan.next();
		char[] digits = in.toCharArray();
		//boolean[] visited = new boolean[digits.length];
		long cur = 0; long mul = 1;
		long ans = 0; long p = 1;
		for(int i = digits.length-1; i >=0; i--){
			long c = Character.getNumericValue(digits[i]);
			cur += c*mul;
			if(cur >= n){
				ans += (cur - c*mul)*p;
				p = p*n;
				cur = c;
				mul = 10;
				int j = 1; int remain0 = 0;
				while(i + j + remain0 < digits.length && digits[i+j+remain0] == '0') {
					c *= 10;
					if(c < n) j++;
					else remain0++;
				}
				if(j != 1){
					for(int k = 1; k < j; k++) {cur *= 10; mul*= 10;}
					mul *= 10;
				}
				if(remain0 != 0) p /= n;
				for(int k = 1; k <= remain0; k++){
					p*= n;
				}
				
			} else {
				mul *= 10;
			}
		}
		System.out.println(ans+ cur*p);
	}
}
