package Div2R401;

import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		int pos = scan.nextInt();
		if(pos == 0 || pos == 2){
			long mod = n%3;
			n = n/3;
			if(n%2 == 1){
				pos = (pos +2)%4;
			}
			if((mod == 1 || mod ==2) && pos == 0 ){
				pos = 1;
			} else if(pos == 2 && mod == 2) pos = 0;
		} else if(pos == 1){
			long mod = n%3;
			n = n/3;
			if(mod == 1) pos = 0;
			else if(mod == 2) pos = 2;
		}
		System.out.println(pos);
	}

}
