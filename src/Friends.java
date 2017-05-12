import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Friends {
	Integer money;
	int factor;
	public Friends(Integer money, int factor){
		this.money=money;
		this.factor=factor;
	}
	static class MyComparator implements Comparator<Friends>{
		public int compare(Friends f1,Friends f2){
			return f1.money.compareTo(f2.money);
		}
	}
	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int d=scan.nextInt();
		List<Friends> a=new ArrayList<Friends>();
		for(int i=0;i<n;i++)
			a.add(new Friends(scan.nextInt(),scan.nextInt()));
		Collections.sort(a, new MyComparator());
		int[] sum=new int[n];
		sum[0]=a.get(0).factor;
		for(int i=1;i<n;i++)
			sum[i]=sum[i-1]+a.get(i).factor;
		int result=a.get(0).factor;
		int min=0;
		int max=a.size();
		while(!a.isEmpty()){
			int minOfMax=a.get(0).money+d;
			max=binarySearch(min,a.size()-1,minOfMax);
			if(max==-1)
				result=Math.max(result, a.get(0).factor);
			else
				{
					result=Math.max(result, sum[max]-sum[min]+a.get(min).factor);
					min=max+1;
				}
			a.remove(0);
			min--;
		}
		System.out.println(result);
	}
	
	public static int binarySearch(int l,int r,int v){
		if(l>r)
			return -1;
		if(l==r)
			return l;
		int mid=(l+r)/2;
		if(v==mid)
			return v;
		else if(v>mid)
			return binarySearch(mid+1,r,v);
		else
			return binarySearch(l,mid-1,v);
	}
}
