package codeforce;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Div2R389C {
	static int[] move_x = {0,1,0,-1};
	static int[] move_y = {1,0,-1,0};
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		String move = scan.next();
		char[] sequence = move.toCharArray();
		int x = 0;
		int y = 0;
		int next_x = 0;
		int next_y = 0;
		Map<Character,Integer> m = new HashMap<Character,Integer>();
		m.put('U', 0); m.put('R', 1); m.put('D', 2); m.put('L', 3);
		int j = -1;
		int ans = 0;
		for(int i = 0; i < n;i++){
			x = x + move_x[m.get(sequence[i])];
			y = y + move_y[m.get(sequence[i])];
			if(i - j != (Math.abs(next_x -x) + Math.abs(next_y - y)))
				{
					ans++;
					next_x = x - move_x[m.get(sequence[i])];
					next_y = y - move_y[m.get(sequence[i])];
					j = i - 1;
				}
		}
		System.out.println(ans+1);
	}
}
