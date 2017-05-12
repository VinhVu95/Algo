package ACM;

import java.util.*;

public class C {


	static ArrayList<ArrayList<Integer>> box = new ArrayList<ArrayList<Integer>>();
	
	static int[] parents;
	
	static int[] howmany;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		in.nextLine();
		
		howmany = new int[n+1];
		parents = new int[n+1];
		
		for (int i = 0; i < n+1; i++) {
			box.add(new ArrayList<Integer>());
			howmany[i] = 0;
			parents[i] = 0;
		}
		
		for (int i = 1; i < n+1; i++) {
			int parent = in.nextInt();
			box.get(parent).add(i);
			parents[i] = parent;
		}
		
		for (int boxi = 1; boxi < n+1; boxi++) {
			//System.out.println("-------------------------");
			//System.out.println("getSize()" + boxi);
			howmany[boxi] = getSize(boxi);
		}
		
		/*for (int boxi = 1; boxi < n+1; boxi++) {
			System.out.println(howmany[boxi]);
			System.out.println(box.get(boxi));
		}*/
		
		//System.out.println(isParent(1,3));
		
		in.nextLine();
		int no_query = in.nextInt();
		in.nextLine();
		for (int i = 0; i <no_query; i++){
			int query_size = in.nextInt();
			int result = 0;
			ArrayList<Integer> currentBoxes = new ArrayList<Integer>();
			for (int j = 0; j < query_size;j++){
				int nextBox = in.nextInt();
				currentBoxes.add(nextBox);
			}
			
			for (int box = 0 ; box < currentBoxes.size(); box++) {
				for (int box2 = box +1 ; box2 < currentBoxes.size(); box2++) {
					if (isParent(box, box2)) {
						currentBoxes.remove(box2);
					}
				}
			}
			
			for (int box = 0 ; box < currentBoxes.size(); box++) {
				result += howmany[currentBoxes.get(box)];
			}
			
			System.out.println(result);
			in.nextLine();
		}
	}
	
	static int getSize(int i) {

		if (howmany[i] != 0) return howmany[i];
		
		int size = 1;
		
		for (int j = 0; j < box.get(i).size(); j++){
			size += getSize(box.get(i).get(j));
		}
		
		return size;
	}	
	
	// if i is parent of j
	static boolean isParent(int i, int j) {
		if (howmany[i] <= howmany[j]) return false;
		int parent_j = parents[j];
		while (parent_j != 0) {
			if (parent_j == i) {
				return true;
			}
			parent_j = parents[j];
		}
		return false;
	}
}
