import java.util.ArrayList;
import java.util.List;


public class Diffk {
	public static void main (String[] args){
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(2);
		a.add(3);
		a.add(4);
		System.out.println(diffPossible(a, 0));
	}
	
	public static int diffPossible(List<Integer> a, int b) {
	    int l = a.size();
	    
	    for(int i = 0; i < l-1; i++ ){
	        int k = b + a.get(i);
	        int h =  i + 1;
	        int t = l - 1;
	        while(h <= t){
	            int mid = a.get((h + t)/2);
	            if (mid < k)
	                h = mid + 1;
	            else if(mid > k)
	                t = mid - 1;
	            else
	                return 1;
	        }
	    }
	    return 0;
	}
}

