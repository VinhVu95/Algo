import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class A384 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a = scan.nextInt();
		int b = scan.nextInt();
		int[] comp = new int[n];
		int in = scan.nextInt();
		for(int i = n-1; i <= 0;i--){
			comp[i] = in % 10;
			in = in / 10;
		}
		if(comp[a-1] == comp[b-1])
				System.out.println(0);
		else{
			System.out.println(1);
		}
		
			
		
	}
	
}
