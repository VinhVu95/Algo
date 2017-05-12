import java.util.ArrayList;
import java.util.List;


public class IntersectionOfSortedArr {
	public static void main(String[] args){
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		a.add(10000);
		b.add(10000);
		intersect(a, b);
	}
	
	public static ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    int i = 0;
	    int j = 0;
	    while(i < a.size() && j < b.size())
	    {
	        if(a.get(i).intValue() == b.get(j).intValue())
	            {
	                res.add(a.get(i));
	                i++;
	                j++;
	            }
	        else if (a.get(i) < b.get(j))
	            i++;
	        else
	            j++;
	    }
	    return res;    
	    
	}
}
