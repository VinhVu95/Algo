package Div2R395;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class C {
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
	static int[] colors;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		colors = new int[n];
		for(int i = 0; i < n ;i++) tree.add(new ArrayList<Integer>());
		for(int i = 0; i < n - 1; i++){
			int u = scan.nextInt();
			int v = scan.nextInt();
			tree.get(u-1).add(v); tree.get(v-1).add(u);
		}
		for(int i = 0; i < n; i++){
			colors[i] = scan.nextInt();
		}
		solve(-1,1,-1);
		
	}
	
	public static void solve(int prev, int cur, int prevColor){
		HashMap<Integer, Integer> colorNeighbor = new HashMap<Integer,Integer>();
		HashSet<Integer> unique = new HashSet<Integer>();
		if( prev != -1 && prevColor != -1) {
			colorNeighbor.put(prev,prevColor);
			unique.add(prevColor);
		}
		for(int neighbor: tree.get(cur-1)){
			if(neighbor != prev)	colorNeighbor.put(neighbor,dfs(neighbor, cur));
		}
		unique.add(colors[cur-1]);
		int num = 0; int next = 0;
		for(int c: colorNeighbor.keySet()){
			if(	colorNeighbor.get(c) == -1) {num++; next = c;}
			else unique.add(colorNeighbor.get(c));
		}
		if(num > 1){
			System.out.println("NO");
		} else if( num == 0){
			System.out.println("YES"); System.out.println(cur); 
		} else {
			if(unique.size() > 1) System.out.println("NO");
			else {
				solve(cur, next, colors[cur-1]);
			}
		}
	}
	
	public static int dfs(int start, int prev){
		int color = colors[start-1];
		Stack<Integer> s = new Stack<Integer>();
		s.push(start);
		HashSet<Integer> visited = new HashSet<Integer>(); visited.add(start);
		while(!s.isEmpty()){
			int p = s.pop();
			for(int neighbor: tree.get(p-1)){
				if(neighbor != prev){
					if(colors[neighbor-1] != color) return -1;
					if(!visited.contains(neighbor)) {s.push(neighbor); visited.add(neighbor);} 
				}
			}
		}
		return color;
	}

}
