package ER17;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		int k = scan.nextInt();
		List<Long> div = new ArrayList<Long>();
		for(int i = 1; i <= Math.sqrt((double)n); i++){
			if(n % (long)i == 0) {div.add((long)i); if(n/i != (long) i) div.add(n/i);}
		}
		Collections.sort(div);
		//System.out.println(div);
		if(div.size() < k)
			System.out.println(-1);
		else
			System.out.println(div.get(k-1));
	}

}
