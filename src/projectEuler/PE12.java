package projectEuler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PE12 {
	static int size = 200001;
    static boolean[] primeSieve = new boolean[size];
    static ArrayList<Integer> primes = new ArrayList<Integer>();
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        for(int i = 2; i < size; i++){
            if(!primeSieve[i]){
                primes.add(i);
                int j = 2*i;
                while(j < size){
                    primeSieve[j] = true;
                    j += i;
                }
            }
        }
        
        int T = scan.nextInt();
        for(int t = 0; t < T; t++){
            int n = scan.nextInt();
            System.out.println(firstTriangleNum(n));
        }
    }
    
    public static long firstTriangleNum(int n){
        int cntFactor = 1;
        int i = 1;
        while(cntFactor <= n){
            if(i%2==0){
                cntFactor = countFactor(i/2)*countFactor(i+1);
                //System.out.println("Count Factor: " + countFactor(i/2) + " " + countFactor(i+1));
            } else 
            	cntFactor = countFactor((i+1)/2)*countFactor(i);
            i++;
        } 
        return (long)(i-1)*i/2;
    }
    
    public static int countFactor(int num){
        int res = 1;
        int copy = num;
        for(int i = 0; i < primes.size(); i++){
            int p = primes.get(i);
            if(p*p > copy && num != 1) return res*2;
            int cnt = 1;
            while(num % p == 0){
                num /= p;
                cnt++;
            }
            res *= cnt;
            if(num == 1) return res;
        }
        return res;
    }
}
