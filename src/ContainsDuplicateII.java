import java.util.*;
public class ContainsDuplicateII {
	public static void main(String[] args){
		
	}
	public static boolean isContainDuplicate(int[] a,int t,int k){
		TreeSet<Integer> tree=new TreeSet<Integer>();
		for(int i=0;i<a.length;i++)
		{
			tree.add(a[i]);
			if(i>=k)
				tree.remove(a[i-k]);
			if(tree.ceiling(a[i])!= null && tree.ceiling(a[i])-a[i]<=t || tree.floor(a[i])!=null && a[i]-tree.floor(a[i])<=t)
				return true;
		}
		return false;
	}
}
