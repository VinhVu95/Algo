import java.util.*;
public class WordLadder {
	public class WordNode{
		int numSteps;
		String word;
		public WordNode(int numSteps,String word){
			this.numSteps=numSteps;
			this.word=word;
		}
	}
	
	public int ladderLength(String beginWord,String endWord,Set<String> dict){
		int result=0;
		Queue<WordNode> q=new LinkedList<WordNode>();
		q.add(new WordNode(1,beginWord));
		dict.add(endWord);
		while(!q.isEmpty()){
			WordNode top=q.remove();
			String top_word=top.word;
			if(top_word.equals(endWord))
				return top.numSteps;
			char[] arr=top_word.toCharArray();
			for(int i=0;i<arr.length;i++)
			{
				char temp=arr[i];
				for(char c='a'; c<='z';c++)
				{
					arr[i]=c;
					String new_word=new String(arr);
					if(dict.contains(new_word))
					{
						q.add(new WordNode(top.numSteps+1,new_word));
						dict.remove(new_word);
					}
				}
				arr[i]=temp;
			}
		}
		return result;
	}
}
