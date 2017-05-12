
public class LengthOfLastWord {
	public static void main(String[] args){
		System.out.print(lengthOfLastWord("I am invicible"));
	}
	public static int lengthOfLastWord(String str){
		if(str=="")
			return 0;
		int result=0;
		str.toLowerCase();
		for(int i=str.length()-1;i>=0;i--)
		{
			char c=str.charAt(i);
			if(c>='a' && c<='z')
				continue;
			if(c==' ')
			{
				result=str.length()-1-i;
				break;
			}
		}
		return result;
	}
}
