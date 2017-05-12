package contest;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Scanner;

public class Div2R392A {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		int max = -100001;
		for(int i = 0; i < n; i++){
			a[i] = scan.nextInt();
			max = Math.max(max, a[i]);
		}
		int ans = 0;
		for(int i = 0; i < n; i++){
			ans += Math.abs(max-a[i]);
		}
		System.out.println(ans);
	}
}
