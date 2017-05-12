package ACM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Boxes {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		scan.nextLine();
		//System.out.println(N);
		List<Box> boxes = new ArrayList<Box>();
		for(int i = 0; i< N;i++){
			boxes.add(new Box(i+1));
		}
		for(int i = 1; i<=N;i++)
		{
			int containBoxi = scan.nextInt();
			if(containBoxi != 0){
				boxes.get(containBoxi -1).addBox(boxes.get(i-1));	
			}
		}
		/*for(Box b: boxes){
			for(Box ctb: b.containedBox){
				System.out.print(ctb.index);
			}
			System.out.println();
		}*/
		scan.nextLine();
		int no_query = scan.nextInt();
		scan.nextLine();
		//System.out.println("Q" + no_query);
		int[] res = new int[no_query];
		for(int i = 0 ; i < no_query; i++){
			
			int M = scan.nextInt();
			//System.out.println("M " + M);
			//System.out.println(M);
			Map<Integer,Integer> visitedBoxes = new HashMap<Integer,Integer>();
			int[] startBoxes = new int[M];
			for(int j = 0; j < M;j++)
			{
				int bi = scan.nextInt();
				visitedBoxes.put(bi,0);
				startBoxes[j] = bi;
			}
			for(int j = 0; j< M;j++){
				if(visitedBoxes.get(startBoxes[j]) == 0){
					visitedBoxes.put(startBoxes[j],1);
					res[i] += numBox(boxes.get(startBoxes[j] - 1),visitedBoxes);
				}
			}
			scan.nextLine();
		}
		
		for(int i= 0; i< no_query; i++){
			System.out.println(res[i]);
		}
	}
	
	public static int numBox(Box startBox,Map<Integer,Integer> visitedBoxes){
		Stack<Box> s = new Stack<Box>();
		int res = 0;
		s.push(startBox);
		while(!s.isEmpty()){
			Box cur = s.pop();
			res++;
			if(visitedBoxes.containsKey(cur.index) && visitedBoxes.get(cur.index) == 0){
				visitedBoxes.put(cur.index,1);
			}
			for(Box contained: cur.containedBox){
				
				s.push(contained);
				if(visitedBoxes.containsKey(contained.index) && visitedBoxes.get(contained.index) == 1)
					s.pop();
			}
		}
		return res;
	}
	
	public static class Box{
		int index;
		ArrayList<Box> containedBox;
		public Box(int index){
			this.index = index;
			containedBox = new ArrayList<Box>();
		}
		
		public void addBox(Box box){
			this.containedBox.add(box);
		}
	}
}
