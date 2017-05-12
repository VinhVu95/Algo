package R399;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class B {
	public static ArrayList<Long> list = new ArrayList<Long>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		long l = scan.nextLong();
		long r = scan.nextLong();
		//list.add(n);
		if(n == 0){System.out.println(0); return;}
		long right = 0, x =n;
		while(x > 0){
			right = 2*right +1;
			x = x/2;
		}
		//System.out.println(right);
		long ans = recur(l,r,n,1, right);
		System.out.println(r-l +1 -ans);
		
	}
	
	public static long recur(long l, long r, long n, long left, long right){
		long ans = 0;
		if(n > 1 && l <= r && left <= right){
			long mid = (left + right)/2;
			if(n%2 == 0) ans = 1;
			if(l <= mid && mid <= r){
				 return recur(l, mid - 1, n/2,left, mid - 1) + recur(mid+1, r, n/2, mid+1, right) + ans;
			} else if(l >= mid){
				return recur(l,r,n/2, mid + 1, right);
			} else if(r <= mid){
				return recur(l,r,n/2, left, mid - 1);
			}
		} 
		return ans;
	}

}
