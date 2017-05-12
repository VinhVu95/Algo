
public class CountAndSay {
	public static void main(String[] args){
		System.out.println(buildString(5));
	}
	public static String buildString(int n){
		String result="1";
		int i=1;
		while(i<n)
		{
			StringBuilder sb=new StringBuilder();
			int j=0;
			while(j<result.length())
			{	
				int count=1;
				char c=result.charAt(j);
				//int k=j;
				while(j<result.length()-1 && result.charAt(j)==result.charAt(j+1))
				{
					count++;
					j++;
				}
				sb.append(String.valueOf(count));
				sb.append(c);
				j++;
			}
			result=sb.toString();
			i++;
		}
		return result;
	}
}
