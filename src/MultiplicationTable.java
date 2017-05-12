import java.util.Scanner;

public class MultiplicationTable {
	public static void main(String args[]){
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int x= s.nextInt();
		int count=0;
		//int[][] multiTable= new int[n][n];
		//for(int i=0;i<n;i++)
			//for(int j=0;j<n;j++)			
				//multiTable[i][j]=(i+1)*(j+1);
		for(int i=1;i<=n;i++)
			if(i<=Math.sqrt(x)&& x%i==0 && x/i<=n)
				{
					count=count+2;
					if(i==x/i)
						count=count-2+1;
				}
			 
			
			/*for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
				if(multiTable[i][j]==x)
					count++;
		count=count*2;
		for(int i=0;i<n;i++)
				if(multiTable[i][i]==x)
					count++;*/
		System.out.println(count);
		s.close();
		}
}
