package ACM;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class CantinaBabel {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter(System.getProperty("line.separator"));
        int N = scan.nextInt();
        List<Character> characters = new ArrayList<Character>();
        
        //List of characters can understand character i
        List<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
        
        //Input list of character
        for(int i = 0; i< N;i++){
            String str = scan.next();
            String[] input = str.split("\\s+");
            //System.out.println(input[0]);
            //System.out.println(input[1]);
            Character character = new Character(i,input[0],input[1]);
            map.add(new ArrayList<Integer>());
            if(input.length > 2)
                for(int j = 2; j < input.length; j++){
                    character.addLang(input[j]);
                }
            characters.add(character);
        }
        
        
        //Build directed map
        for(Character character: characters){
        	for(Character underChar: characters){
        		if (character.v != underChar.v && underChar.canUnderstand(character.spokenLang)){
        			map.get(character.v).add(underChar.v);
        			//System.out.println(character.v + " " + underChar.v);
        		}
        	}
        }
        
        //Check if character already in converse group
        boolean[] inGroup = new boolean[N];
        boolean[] visited = new boolean[N];
        
        //Find group with max character
        int max = 0;
     
        //Construct group of conversable characters
        for(int i = 0; i < N;i++)
        {
        	if(!inGroup[i]){
        		inGroup[i] = true;
        		List<Integer> newGroup = new ArrayList<Integer>();
        		newGroup.add(i);
        		for(int j = 0; j< N;j++) visited[j] = false;
        		for(int j = 0; j < N; j++)
        		{
        			//System.out.println(i + " " + j + " " + dfs(map,i,j));
        			if(j != i && !inGroup[j] && dfs(map,i,j) && dfs(map,j,i))
        				{
        					newGroup.add(j);
        					inGroup[j] = true;
        				}
        		}
        		//System.out.println("Group size: " + newGroup.size());
        		max = Math.max(newGroup.size(), max);
        	}
        }
        	
        
        System.out.println(N - max);
        
    }
    
    public static boolean dfs(List<ArrayList<Integer>> map,int start,int end){
    	boolean[] visited = new boolean[map.size()];
        Stack<Integer> s = new Stack<Integer>();
        s.push(start);
        while(!s.isEmpty()){
            int cur = s.pop();
            visited[cur] = true;
            
            for(int neighbor: map.get(cur)){
                if(!visited[neighbor])
                    {
                		if(neighbor == end)
                			return true;
                		s.push(neighbor);
                    }
            }
        }
        return false;
    }
    
    static class Character{
        String name;
        String spokenLang;
        int v;
        HashSet<String> listenLang;
        public Character(int v,String name, String spokenLang){
            listenLang = new HashSet<String>();
            this.v = v;
            this.name = name;
            this.spokenLang = spokenLang;
            listenLang.add(spokenLang);
        }
        
        public void addLang(String lang){
            this.listenLang.add(lang);
        }
        
        public boolean canUnderstand(String lang){
            return listenLang.contains(lang);
        }
    }
}