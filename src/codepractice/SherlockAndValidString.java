package codepractice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class SherlockAndValidString {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String in = scan.next();
        char[] c = in.toCharArray();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < c.length; i++){
            if(!map.containsKey(c[i]))
                map.put(c[i],1);
            else
            {
                int t = map.get(c[i]);
                map.put(c[i],t+1);
            }
        }
        boolean res = true;
        boolean flag = false;
        Iterator<Character> i = map.keySet().iterator();
        int _m = 0;
        while(i.hasNext()){
            int m = map.get(i.next());
            if(_m == 0)
                _m = m;
            else{
                if(Math.abs(m-_m) > 1)
                {
                	if(m != 1 && _m != 1)
                		res = false;
                	else
                		flag = true;
                }
                else if (Math.abs(m-_m) == 1)
                {
                    if(flag)
                    {
                        res = false;
                        
                    }
                    else
                        flag = true;
                    if(!i.hasNext() && m < _m && m != 1)
                        res = false;
                    _m = Math.min(m,_m);
                }
            }
            
        }
        if(res)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
