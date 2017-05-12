package Div2R393;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m =  scanner.nextInt();
        int k =  scanner.nextInt()-1;
        int remainPillow = m-n;

        int prodoPillow = 1;
        int left = 0;
        int right = 0;
        int maxLeft = k;
        int maxRight = n-1 - k;
        while(left+right+1 <= remainPillow){
            if(left == maxLeft && right==maxRight){
                int t = left + right +1;
                prodoPillow += remainPillow/t;
                break;
            }
            prodoPillow++;
            remainPillow = remainPillow - left-right-1;
            if(left<maxLeft){
                left++;
            }
            if(right<maxRight){
                right++;
            }
        }
        System.out.println(prodoPillow);
	}

}
