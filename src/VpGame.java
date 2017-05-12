import java.util.*;

public class VpGame {
  public static void main(String[] args){
	Scanner scan=new Scanner(System.in);
	int n=scan.nextInt();
	int k=0;
	int[] p_array=new int[n+1];
	ArrayList result=new ArrayList();
	p_array[1]=1;
	for(int i=2;i<=n;i++)
	{
		if(p_array[i]==0)
		{
			int q=i*2;
			while(q<=n)
			{
				p_array[q]=1;
				q+=i;
			}
		}
	}
	for(int i=2;i<=n;i++)
	{
		if(p_array[i]==0)
		{
			k++;
			result.add(i);
			int r=i*i;
			while(r<=n)
			{
				k++;
				result.add(r);
				r*=i;
			}
		}
	}
	System.out.println(k);
	for(int i=0;i<k;i++)
		System.out.print(result.get(i)+" ");
	scan.close();		
	}
  }
