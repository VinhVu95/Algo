package R399;

import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] str = new int[n];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i< n; i++){
			str[i] = scan.nextInt();
			min = Math.min(min,str[i]);
			max = Math.max(max,str[i]);
		}
		int ans = 0;
		for(int i = 0; i < n; i++){
			if(str[i] != min && str[i] != max) ans++;
		}
		System.out.println(ans);
	}

}
