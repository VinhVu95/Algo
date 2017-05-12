package contest;

import java.util.Scanner;

public class Div2R392C {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		long[][] asks = new long[n][m];
		long k = scan.nextLong();
		int x = scan.nextInt();
		int y = scan.nextInt();
		long remain;
		long mod;
		//System.out.println(mod);
		if(n == 1){
			remain = k / m;
			mod = k%m;
			for(int i = 0; i < m; i++){
				if(mod > 0){
					asks[0][i] = remain + 1;
					mod--;
				} else {
					asks[0][i] = remain;
				}	
			}
		}
		else if(n == 2){
			remain = k / (2*m);
			mod = k % (2*m);
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					if(mod > 0){
						asks[i][j] = remain + 1;
						mod--;
					} else {
						asks[i][j] = remain;
					}
				}
			}
		} else {
			remain = k / ((2*n-2)*m);
			mod = k%((2*n-2)*m);
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
							if(i == 0 || i == n-1) asks[i][j] = remain;
							else asks[i][j] = remain*2;
							if(mod > 0){
								asks[i][j]++;
								mod--;
							}
				}
			}
			for(int i = n - 2; i >= 1; i--){
				for(int j = 0; j < m; j++){
					if(mod > 0){
						asks[i][j]++;
						mod--;
					}
				}
			}
		}
		
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				min = Math.min(asks[i][j], min);
				max = Math.max(asks[i][j], max);
			}
		}
		System.out.println(max + " " + min + " " + asks[x-1][y-1]);
		
	}
}
