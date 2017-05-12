package Div2R398;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class C {
	public static int x,u,v,root;
	public static ArrayList<Integer> children[];
	public static int[] temp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyScanner scan = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int n = scan.nextInt();
		children = new ArrayList[n+1];
		temp = new int[n+1];
		root = 0; u = 0; v = 0;
		for(int i = 1; i <= n; i++){
			children[i] = new ArrayList<Integer>();		
		}
		for(int i = 1; i <= n; i++){
			int c = scan.nextInt();
			int t = scan.nextInt();
			temp[i] = t; x += t;
			if(c!=0) children[c].add(i);
			else root = i;
		}
		if(x % 3 != 0) System.out.println(-1);
		else {
			dfs(root);
			System.out.println(-1);
		}
	}	
	
	public static void dfs(int node){
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		s1.push(node);
		while(!s1.isEmpty()){
			int cur = s1.pop();
			s2.push(cur);
			for(int child: children[cur]){
				s1.push(child);
			}
		}
		while(!s2.isEmpty()){
			int p = s2.pop();
			for(int c: children[p]) temp[p] += temp[c];
			if(temp[p] == x/3 && p != root){
				if(u == 0) {
					u = p; temp[u] = 0;
				} else if (v == 0){
					v = p; temp[v] = 0;
				}
			}
			if(u != 0 && v!= 0)
				{
					System.out.println(u + " " + v);
					System.exit(0);
				}
		}
		
	}
	
	public static PrintWriter out;
	
	public static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
	      }
	 
	      String next() {
	          while (st == null || !st.hasMoreElements()) {
	              try {
	                  st = new StringTokenizer(br.readLine());
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          }
	          return st.nextToken();
	      }
	 
	      int nextInt() {
	          return Integer.parseInt(next());
	      }
	 
	      long nextLong() {
	          return Long.parseLong(next());
	      }
	 
	      double nextDouble() {
	          return Double.parseDouble(next());
	      }
	 
	      String nextLine(){
	          String str = "";
		  try {
		     str = br.readLine();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return str;
	      }

	   }

}