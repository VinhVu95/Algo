package codeforce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Div2R385C {
	static int n;
	static int m;
	static int k;
	static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
	static boolean[] visited;
	static Stack<Integer> s = new Stack<Integer>();
	static Set<Integer> gover;
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		k = scan.nextInt();
		gover = new HashSet<Integer>();
		for(int i = 0;  i < k ; i++){
			int g = scan.nextInt();
			gover.add(g);
		}
		for(int i = 0; i < n; i++){
			map.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < m; i++){
			int x = scan.nextInt();
			int y = scan.nextInt();
			map.get(x-1).add(y);
			map.get(y-1).add(x);
		}
		visited = new boolean[n+1];
		ArrayList<ConnectedComponent> comp = new ArrayList<Div2R385C.ConnectedComponent>();
		for(int i = 1; i <= n; i++){
			if(!visited[i]){
				comp.add(dfs(i));
			}
		}
		int ans = 0;
		int nonGov = 1;
		int max = -99999999;
		int numNonGov = 0;
		for(ConnectedComponent c: comp){
			System.out.println(c.vertices);
			int add = 0;
			for(int v: c.vertices){
				add += (c.vertices.size() - map.get(v-1).size() - 1);
			}
			ans += add/2;
			System.out.println(ans);
			
			if(!c.hasGov){
				nonGov *= c.vertices.size();
				numNonGov++;
			} else{
				max = Math.max(max, c.vertices.size());
			}
		}
		if(numNonGov == 0)
			nonGov = 0;
		ans += (nonGov*max);
		System.out.println(ans);
		
	}
	
	public static ConnectedComponent dfs(int start){
		s.push(start);
		ConnectedComponent cc = new ConnectedComponent();
		visited[start] = true;
		while(!s.isEmpty()){
			int c = s.pop();
			
			cc.vertices.add(c);
			if(gover.contains(c)){
				cc.hasGov = true;
			}
			for(int neighbor: map.get(c-1)){
				if(!visited[neighbor]){
					s.push(neighbor);
					visited[neighbor] = true;
				}
			}
		}
		return cc;
	}
	
	public static class ConnectedComponent{
		boolean hasGov;
		ArrayList<Integer> vertices;
		public ConnectedComponent(){
			this.vertices = new ArrayList<Integer>();
		}
		
	}
}
