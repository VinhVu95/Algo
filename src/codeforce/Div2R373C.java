package codeforce;

import java.util.Scanner;

public class Div2R373C {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int t = scan.nextInt();
		double score = scan.nextDouble();
		double dec = score - Math.floor(score);
		int integer = (int) Math.floor(score);
		int x = integer;
		int l = 0;
		System.out.println(x + " " + dec);
		while(x > 0){
			x = x/10;
			l++;
		}
		int[] decimalPlaces = new int[n-l-1];
		int i = 0;
		while(dec > 0){
			dec = dec*10;
			 int c = (int) (dec - Math.floor(dec));
			 decimalPlaces[i++] = c;
			 if(c >= 5) break;
			 System.out.println(c);
		}
		
		i -= 2;
		while(t > 0 && i >= 0){
			decimalPlaces[i] = (decimalPlaces[i] + 1)%10;
			t--;
			if(decimalPlaces[i] < 5 && decimalPlaces[i] > 0)
				break;
			i--;
		}
	}
}
