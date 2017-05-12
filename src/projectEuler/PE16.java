package projectEuler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PE16 {
    static ArrayList<Integer> listDigits = new ArrayList<Integer>();
    static int[] sumDigits = new int[10001];
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int num = 1;
        listDigits.add(1);
        for(int i = 1; i < 10001; i++){
            int carry = 0;
            int c = 0;
            int l = listDigits.size();
            for(int j = l-1; j >= 0; j--){
                c = 2*listDigits.get(j) + carry;
                if(c  < 10) {
                  listDigits.set(j,c);
                  carry = 0;
                }
                else {
                  listDigits.set(j, c%10);
                  carry = c/10;
                }
            }
            if (carry > 0) listDigits.add(0,carry);
            for(int d: listDigits) sumDigits[i] += d;
        }
        
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int i = 0; i < T; i++){
            int N = scan.nextInt();
            System.out.println(sumDigits[N]);
        }
    }   
}
