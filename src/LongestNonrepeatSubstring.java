
public class LongestNonrepeatSubstring {
	public static void main(String[] args){
		String str="abcdfeacfdebi";
		System.out.println(longestLength(str));
	}
	public static int longestLength(String s){
		if(s==null)
			return 0;
		int[] is_visited =new int[256];
		int max_length=0;
		int cur_head=0;
		int[] last_index=new int[256];
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(is_visited[c]==0)
				{
					is_visited[c]=1;
					last_index[c]=i;
				}
			else
			{
				if(cur_head<=last_index[c])
				{
					cur_head=last_index[c]+1;
					last_index[c]=i;
				}
			}
			max_length=Math.max(max_length, i-cur_head+1);
		}
		return max_length;
	}
}
