package ACM;

import java.util.Scanner;

public class SecretMessage {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		String[] res = new String[N];
		for(int i = 0; i < N;i++)
		{
			res[i] = encrypt(scan.next());
		}
		for(int i = 0; i < N;i++)
			System.out.println(res[i]);
	}
	
	public static String encrypt(String message){
		int l = message.length();
		int n = (int) Math.ceil(Math.sqrt( (double) l));
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i< n*n - l;i++)
			sb.append('*');
		String exMessage = message + sb.toString();
		//System.out.println(exMessage);
		StringBuffer res = new StringBuffer();
		for(int i = 0; i < n;i++)
			for(int j =0; j < n;j++)
			{
				char ch = exMessage.charAt((n-1-j)*n +i);
				if(ch != '*')
					res.append(ch);
			}
		
		return res.toString();
	}
}
