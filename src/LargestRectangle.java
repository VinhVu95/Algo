import java.util.*;
public class LargestRectangle {
	public static void main(String[] args){
		int[] a= {1,2,3,2,4,6,5,2,1};
		System.out.print(findLargestRectangle(a));
	}
	public static int findLargestRectangle(int[] a){
		Stack<Integer> s=new Stack<Integer>();
		s.push(0);
		int maxArea=0;
		for(int i=1;i<a.length;i++)
		{
			while(!s.isEmpty() && a[s.peek()]>=a[i])
			{
				int h=s.pop();
				maxArea=Math.max((i-h)*a[h], maxArea);
			}
			int k=s.isEmpty()? i : i-s.peek();
			maxArea=Math.max(k*a[i],maxArea);
			s.push(i);
		}
		return maxArea;
	}
}
