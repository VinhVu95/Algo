import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
	public static int longestConsecutiveSequence(int[] arr){
		if (arr.length==0)
			return 0;
		Set<Integer> s= new HashSet<Integer>();
		for(int a: arr)
			s.add(a);
		int result=0;
		for(int a: arr)
		{
			int count=1;
			int left=a-1;
			int right=a+1;
			while(s.contains(left))
			{
				s.remove(left);
				count++;
				left--;
			}
			while(s.contains(right))
			{
				s.remove(right);
				count++;
				right++;
			}
			result=Math.max(result, count);
		}
		return result;
	}
}
