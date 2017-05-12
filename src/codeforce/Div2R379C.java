package codeforce;

import java.util.Scanner;

public class Div2R379C {
	static long[] secPot;
	static long[] secMana;
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		int m = scan.nextInt();
		int k = scan.nextInt();
		long x = scan.nextLong();
		long s = scan.nextLong();
		long[] firstTime = new long[m];
		long[] firstMana = new long[m];
		for(int i = 0; i < m; i++){
			firstTime[i] = scan.nextLong();
		}
		for(int i = 0; i < m; i++){
			firstMana[i] = scan.nextLong();
		}
		secPot = new long[k];
		secMana = new long[k];
		for(int i = 0; i < k; i++){
			secPot[i] = scan.nextLong();
		}
		for(int i = 0; i < k; i++){
			secMana[i] = scan.nextLong();
		}
		long time = n*x;
		long j = 0;
		int i = 0;
		long timeEachPot = x;
		do{
			if(j <= s ){
				long remainMana = s - j;
				int idx = binarySearch(0, secMana.length - 1,remainMana);
				long imPre = idx == -1 ? 0: secPot[idx];
				if(n <= imPre)
					time = 0;
				else
					time = Math.min(time, (n - imPre)*timeEachPot);
			}
			if(i >= m) break;
			timeEachPot = firstTime[i];
			j = firstMana[i];
			i++;
			
		} while(s > 0 && i <= m);
		System.out.println(time);
	}
	
	public static int binarySearch(int low, int high, long x){
		if (low > high)
	        return -1;
	 
	    // If last element is smaller than x
	    if (x >= secMana[high])
	        return high;
	 
	    // Find the middle point
	    int mid = (low+high)/2;
	 
	    // If middle point is floor.
	    if (secMana[mid] == x)
	        return mid;
	 
	    // If x lies between mid-1 and mid
	    if (mid > 0 && secMana[mid-1] <= x && x < secMana[mid])
	        return mid-1;
	 
	    // If x is smaller than mid, floor must be in
	    // left half.
	    if (x < secMana[mid])
	        return binarySearch(low, mid-1, x);
	 
	    // If mid-1 is not floor and x is greater than
	    // arr[mid],
	    return binarySearch(mid+1, high, x);
			
	}
	
	
}
