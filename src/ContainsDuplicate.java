import java.util.*;
public class ContainsDuplicate {
	public static boolean isContainDuplicate(int[] a,int k){
		Map<Integer,Integer> m=new HashMap<Integer,Integer>();
		for(int i=0;i<a.length;i++)
		{
			if(m.containsKey(a[i]))
			{
				if(i-m.get(a[i])<= k)
					return true;
				m.put(a[i], i);
			
			}
		}
		return false;
	}
}
