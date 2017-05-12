package contest;

import java.util.ArrayList;
import java.util.Scanner;

public class Div2R392B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String in = scan.next();
		char[] light = in.toCharArray();
		
		int[] mark = new int[4];
		int[] rbyg = new int[4];
		for(int i = 0; i < light.length ; i ++){
			if(light[i] == 'R')
				mark[0] = i;
			else if(light[i] == 'B')
				mark[1] = i;
			else if(light[i] == 'Y')
				mark[2] = i;
			else if(light[i] == 'G')
				mark[3] = i;
		}
		for(int i = 0; i < light.length; i++){
			if(light[i] == '!')
				if(i%4 == mark[0] % 4)
					rbyg[0]++;
				else if(i%4 == mark[1] % 4)
					rbyg[1]++;
				else if(i%4 == mark[2] % 4)
					rbyg[2]++;
				else if(i%4 == mark[3] % 4)
					rbyg[3]++;
		}
	
		
		for(int i = 0; i < 4; i++)
		{
			System.out.print(rbyg[i]+ " ");
		}
	}

}
