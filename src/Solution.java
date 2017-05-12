

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    

	/*
 * Complete the function below.
 */

    static int numberOfPairs(int[] a, long k) {
    
       Map<Long,Integer> map = new HashMap<Long,Integer>();
	   int result = 0;
	   for(int i = 0; i< a.length; i++)
	   {
		   //int x = k - a[i];
		   if(map.containsKey((long)a[i]))
		   {
			   int freq = map.get((long)a[i]);
			   map.put((long)a[i], freq + 1);
		   } else
			   map.put((long)a[i], 1);
		   System.out.println(a[i] + " " + map.get((long)a[i]));
	   }
	   Set<Long> keys = map.keySet();
	   Iterator<Long> it = keys.iterator();
	   while(it.hasNext())
	   {
		   long cur = it.next();
		   if( k % 2 != 0 || cur != k/2){
			   if(keys.contains(k - cur))
				   result++;
		   }
	   }
	   System.out.println("After iterate :" + result);
	   result /= 2;
	   //System.out.println(map.get(k/2));
	   if(k % 2 == 0 && keys.contains(k/2) && map.get(k/2) > 1)
		   result += 1;
	   return result;
    }
    
    public static void main(String[] args) throws IOException{
        /*Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        
        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        int[] _a = new int[_a_size];
        int _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine().trim());
            _a[_a_i] = _a_item;
        }
        
        long _k;
        _k = Long.parseLong(in.nextLine().trim());
        
        res = numberOfPairs(_a, _k);
        bw.write(String.valueOf(res));
        bw.newLine();
        
        bw.close();*/
    	int[] test = {
    			6,
    			6,
    			6,
    			6,
    			3,
    			9,
    			9,
    			3,
    			5,
    			1};
    	System.out.println(numberOfPairs(test,12));
    }
}
