
public class SearchInRotatedSortedArray {
	public static void main(String[] args){
		int[] a={4,5,6,7,0,1,2};
		System.out.println(findElement(a,0,a.length-1,0));
	}
	public static int findElement(int[] a,int left,int right,int t){
		if(left==right)
			if(a[left]!=t)
				return -1;
		int mid=(left+right)/2;
		if(a[mid]==t)
			return mid;
		else if(a[left]<a[mid])
		{
			if(t>=a[left] && t <=a[mid])
				return findElement(a, left, mid-1, t);
			else
				return findElement(a,mid+1,right,t);
		}
		else
		{
			if(t<=a[right] && t>=a[mid])
				return findElement(a,mid+1,right,t);
			else
				return findElement(a, left, mid-1, t);
		}
	}

}
