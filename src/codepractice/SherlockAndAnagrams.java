package codepractice;

import java.util.Scanner;

public class SherlockAndAnagrams {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int t = 0; t < T;t++){
			String in = scan.next();
			int res= 0;
			char[] charac = in.toCharArray();
			int l = in.length();
			for(int i = 1; i < l; i++)
			{
				LetterCollection[] col = new LetterCollection[l-i+1];
				col[0] = new LetterCollection();
				
				for(int j = 0; j <= l - i; j++)
				{
					col[j] = new LetterCollection();
					for(int k = 0; k < i; k++){
						col[j].addChar(charac[j+k]);
					}
				}
				for(int j = 0; j <= l - i - 1;j++)
				{
					for(int k = j + 1; k <= l - i; k++)
						if(checkAnagram(col[j],col[k]))
							res++;
				}
			}
			System.out.println(res);
		}
    }
	
	public static boolean checkAnagram(LetterCollection col1, LetterCollection col2){
		for(int i = 0; i < 26; i++){
			if(col1.countChar[i] != col2.countChar[i])
				return false;
		}
		return true;
	}
	
    
    public static class LetterCollection{
        int[] countChar = new int[26];
        
        public void addChar(char c){
        	countChar[c - 97]++;
        }
        
    }
}
