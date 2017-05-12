package codeforce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EightVCC {
	static Map<Integer, ArrayList<Integer>> set;
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] mostDis = new int[n+1];
		int[] tree = new int[n+1];
		set = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int i = 1; i < n+1; i++){
			mostDis[i] = scan.nextInt();
			tree[i] = i;
			ArrayList<Integer> v = new ArrayList<Integer>();
			v.add(i);
			set.put(i, v);
		}
		
		for(int i = 1; i < n+1; i++){
			if(tree[i] != tree[mostDis[i]]){
				merge(tree, i, mostDis[i]);
			}
		}
		System.out.println(set.size());
	}
	
	public static void merge(int[] tree, int i, int j){
		int m = tree[j];
		for(int k: set.get(tree[j])){
			tree[k] = tree[i];
		}
		ArrayList<Integer> r = set.remove(m);
		ArrayList<Integer> o = set.remove(tree[i]);
		o.addAll(r);
		set.put(tree[i],o);
	}
}
