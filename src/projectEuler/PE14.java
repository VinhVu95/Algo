package projectEuler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PE14 {

	static int size = 5000001;
    static long[] chain_length = new long[size];
    static long[] max_chain_length = new long[size];
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        long max_len = Integer.MIN_VALUE;
        for(int i = 2; i < size; i++){
            long j = i;
            int k = 0;
            while(j != 1 && j >= i){
                if( j % 2 == 0) j = j/2;
                else j = 3*j + 1;
                k++;
            }
            chain_length[i] = chain_length[(int)j] + k;
        }
        
        for(int i = 1; i < size; i++){
            if(max_len <= chain_length[i]) {max_chain_length[i] = i; max_len = chain_length[i];}
            else max_chain_length[i] = max_chain_length[i-1];
        }
        int T = scan.nextInt();
        for(int t = 0; t < T; t++){
            int n = scan.nextInt();
            System.out.println(max_chain_length[n]);
        }
    }

}
