package codeforce;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Div2347C {
	static int[] prev;
	static int[] time_so_far;
	static int n;
	static int m;
	static int T;
	static ArrayList<ArrayList<Pair>> map;
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		T = scan.nextInt();
		for(int i = 0; i < n; i++){
			map.add(new ArrayList<Div2347C.Pair>());
		}
		for(int i = m; i < m; i++){
			int u = scan.nextInt();
			int v = scan.nextInt();
			int t = scan.nextInt();
			map.get(u-1).add(new Pair(v,t));
		}
		prev = new int[n+1];
		time_so_far = new int[n+1];
		
	}
	
	private void dfs(){
		Stack<Integer> stk = new Stack<Integer>();
		boolean[] visited = new boolean[n+1];
		stk.push(1);
		visited[1] = true;
		while(!stk.isEmpty()){
			int cur = stk.pop();
			
		}
	}
	
	public static class Pair{
		int neighbor;
		int time;
		public Pair(int neighbor, int time){
			this.neighbor = neighbor;
			this.time = time;
		}
	}
}
