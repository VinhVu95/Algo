package codeforce;

import java.util.Scanner;

public class Div2R386C {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int s = scan.nextInt();
		int x1 = scan.nextInt(), x2 = scan.nextInt();
		double v1 = (double)1/(scan.nextInt()), v2 = (double)1/(scan.nextInt());
		
		int p = scan.nextInt(), d = scan.nextInt();
		int i_d = -1, end = 0;
		if(x1 < x2) {i_d = 1;}
		if(d == 1) end = s;
		int path = 0;
		while((Math.signum((double)x1 - p) != Math.signum((double)i_d) && x1 != p) || i_d != d){
			path += Math.abs(p - end);
			p = end;
			end = s - end;
			d = -d;
		}
		
		path += Math.abs(x1-p);
		double distance = Math.abs(x1- x2);
		double time_to_catch = path/Math.abs(v1- v2);
		long ans = 0;
		if(time_to_catch * v2 >= distance || v1 <= v2){
			ans = Math.round(distance/v2);
		} else {
			ans = Math.round(time_to_catch + (distance - time_to_catch*v2)/v1);
		}
		System.out.println(ans);
	}
}
