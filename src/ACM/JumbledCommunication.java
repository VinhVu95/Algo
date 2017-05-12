package ACM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JumbledCommunication {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		List<String> results = new ArrayList<String>();
		
		while(scan.hasNextLine()){
			Scanner ss = new Scanner(scan.nextLine());
			Scanner ss2;
			if(!ss.hasNext())
				break;
			
			while(ss.hasNext()){
				int N = ss.nextInt();
				 ss2 = new Scanner(scan.nextLine());
				int[] a = new int[N];
				for(int i = 0; i< N;i++){
					a[i] = ss2.nextInt();
				}
				results.add(unscramble(a));
				ss2.close();
			}
		}
		
		for(String s: results){
			System.out.println(s);
		}
	}
	
	public static String unscramble(int[] scramble){
		int[] res = new int[scramble.length];
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i< scramble.length;i++)
		{
			String bits = Integer.toBinaryString(scramble[i]);
			//System.out.println(bits);
			int size = bits.length();
			char[] b = bits.toCharArray();
			char[] reconst = new char[size];
			reconst[size - 1] = b[size -1];
			for(int j = size - 2 ; j >= 0; j-- )
			{
				if(reconst[j + 1] == '1')
				{
					if(b[j] == '0')
						reconst[j] = '1';
					else if(b[j] == '1')
						reconst[j] ='0';
				} else if (reconst[j+1] == '0')
				{
					if(b[j] == '0')
						reconst[j] = '0';
					else if(b[j] == '1')
						reconst[j] = '1';
				}
			}
			//System.out.println(String.valueOf(reconst));
			res[i] = Integer.parseInt(String.valueOf(reconst), 2);
			//System.out.println(res[i]);
			sb.append(res[i]).append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}