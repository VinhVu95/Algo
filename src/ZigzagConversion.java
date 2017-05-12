import java.util.*;
public class ZigzagConversion {
	public static void main(String[] args){
		String s = "PAYPALISHIRING"; 
		System.out.println(zigzagConverse(s, 3));
	}
	
	public static String zigzagConverse(String s,int n){
		int l=s.length();
		String r="";
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++)
		{
			int j=i;
			while(j<l)
			{
				if(i==0 || i==n-1)
				{
					sb.append(s.charAt(j));
					j= j+2*(n-1);
				}
				else
				{
					sb.append(s.charAt(j));
					j=j+2*(n-i-1);
					if(j<l)
						sb.append(s.charAt(j));
					j=j+2*i;
				}
			} 
		}
		r=sb.toString();
		return r;
	}
}
