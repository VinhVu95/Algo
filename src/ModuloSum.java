import java.util.Scanner;

public class ModuloSum {
	public static void main(String args[]){
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int m=s.nextInt();
		String result="NO";
		int[] a=new int[n];
		int[] r=new int[m];
		int[] p=new int[m];
		int anchor1=0;
		int mark=0;
		for(int i=0;i<n;i++)
		{
			a[i]=s.nextInt();
			a[i]=a[i]%m;
		}
		if(n>m)
		    result="YES";
		else
		{
			for(int i=0;i<n;i++)
			{	
				if(a[i]==0)
					result="YES";
				if(r[a[i]]==0)
					{
						r[a[i]]=1;
						if(i==0)
							p[anchor1]=a[0];
						else
						{
							anchor1++;
							p[anchor1]=a[i];
						}
						mark=anchor1;
					}
				else
					mark=anchor1+1;
				int anchor2=0;

				//int mark=anchor1;
				while(anchor2<mark)
				{
					int sum=(a[i]+p[anchor2])%m;
					if(sum==0)
						result="YES";
					if(r[sum]==0)
						{
						   r[sum]=1;
						   anchor1++;
						   p[anchor1]=sum;
						}
					anchor2++;
				}			
			}
		}
		System.out.println(result);
				s.close();
		}

	}

