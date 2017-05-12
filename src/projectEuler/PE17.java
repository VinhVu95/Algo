package projectEuler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PE17 {
    static String[] digits = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen", "Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    static String[] ten = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int t = 0; t < T; t++){
            long N = scan.nextLong();
            if(N == 1000000000000L) System.out.println("Trillion");
            else{
                StringBuilder sb = new StringBuilder();
                if(N/1000000000L > 0){
                	sb.append(threeDigitsNumInWords(N/1000000000L)).append(" Billion ");
                	N %= 1000000000L;
                }
                if(N/1000000 > 0) {
                	sb.append(threeDigitsNumInWords(N/1000000)).append(" Million ");
                	N %= 1000000;
                }
                if(N/1000 > 0) {
                	sb.append(threeDigitsNumInWords(N/1000)).append(" Thousand ");
                	N %= 1000;
                }
                if(N%1000 > 0) sb.append(threeDigitsNumInWords(N%1000));
                System.out.println(sb.toString().trim());
            }
        }
    }
    
    public static String threeDigitsNumInWords(long num){
        StringBuilder sb = new StringBuilder();
        int hundred = (int)(num/100);
        if(hundred > 0) sb.append(digits[hundred]).append(" Hundred ");
        int tenthAndUnits = (int)(num%100);
        if(tenthAndUnits < 20 && tenthAndUnits > 0) sb.append(digits[tenthAndUnits]);
        else{
            int tenth = (int)(tenthAndUnits / 10);
            int unit = (int)(tenthAndUnits % 10);
            sb.append(ten[tenth - 2]).append(" ");
            if(unit > 0) sb.append(digits[unit]);
        }
        return sb.toString().trim();
    }
}