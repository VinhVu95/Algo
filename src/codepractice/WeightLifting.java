package codepractice;
import java.util.*;
public class WeightLifting {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=scan.nextInt();
		Map<Integer,Integer> m=new HashMap<Integer,Integer>();
		
		List<Integer> s=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
			{
				if(!m.containsKey(a[i]))
					{
						m.put(a[i], 1);
						s.add(a[i]);
					}
				else
					increaseValue(m, a[i]);
			}
		int count=0;
		Collections.sort(s);
		int min=s.get(0);
		int j=0;
		while(!m.isEmpty() && m.containsKey(min))
		{
			if(m.get(min)>1)
			{
				int k=min;
				while(m.containsKey(k))
				{
					reduceValue(m,k);
					reduceValue(m,k);
					k++;
				}
				count++;
			}
			if(m.get(min)<=1)
			{
				j++;
				min=s.get(j);
			}
			
		}
		for(int i: m.keySet())
		{
			if(m.get(i)!=0)
				count++;
		}
		System.out.println(count);
		
	}
	
	public static void increaseValue(Map<Integer,Integer> m,int i)
	{
		int p=m.get(i);
		m.remove(i);
		m.put(i, p+1);
	}
	
	public static void reduceValue(Map<Integer,Integer> m,int i)
	{
		int p=m.get(i);
		m.remove(i);
		m.put(i, p-1);
	}
}
