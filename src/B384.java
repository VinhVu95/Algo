import java.util.Scanner;


public class B384 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int h = 1;
		int t = 1;
		for(int i = 0; i < n-1; i++)
			t = 2*t +1;
		System.out.println(search(h,t,k,n));
	}
	
	public static int search(int h,int t, int k,int n){
		while(h < t){
			int mid = (h+t)/2;
			if(k == mid)
				return n;
			else if(k < mid)
				{
					t = mid-1;
					n--;
				}
			else{
				h = mid+1;
				n--;
			}
		}
		return -1;
	}
}
