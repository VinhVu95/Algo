package Div2R401;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		BigInteger s = scan.nextBigInteger();
		BigInteger m = scan.nextBigInteger();
		BigInteger ten = new BigInteger("10");
		int[] sa = new int[n];
		int[] ma = new int[n];
		for(int i = n-1; i >=0 ; i--){
			sa[i] = s.mod(ten).intValue(); s = s.divide(ten) ;
			ma[i] = m.mod(ten).intValue(); m = m.divide(ten) ; 
		}
		Arrays.sort(sa); Arrays.sort(ma);
		int max=0, min = 0;
		int j = 0;
		for(int i = 0; i < n; i++){
			while(j < n && ma[j] <= sa[i]){
				j++;
			}
			if(j < n) {max++; j++;} 
		}
		int k = 0;
		for(int i = 0; i < n; i++){
			while(k < n && ma[k] < sa[i]){
				k++;
			}
			if(k < n) {min++; k++;}
		}
		System.out.println((n-min) + " " + max);
	}

}
