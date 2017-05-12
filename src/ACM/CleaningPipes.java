package ACM;

import java.util.*;

public class CleaningPipes {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int w = scan.nextInt();
		int p = scan.nextInt();
		Point[] wells = new Point[w];
		Map<Integer,ArrayList<Integer>> adjacencyList = new HashMap<Integer,ArrayList<Integer>>();
		
		for(int i =0 ; i<w;i++)
		{
			int x_coor = scan.nextInt();
			int y_coor = scan.nextInt();
			wells[i] = new Point(x_coor,y_coor);
		}
		Segment[] pipes = new Segment[p];
		for(int i = 0;i < p;i++)
		{
			int s = scan.nextInt() - 1;
			int x_end = scan.nextInt();
			int y_end = scan.nextInt();
			Point end = new Point(x_end,y_end);
			pipes[i] = new Segment(wells[s],end);
			adjacencyList.put(i,new ArrayList<Integer>());
			for(int j = 0 ; j < i;j++)
			{
				if(isIntersected(pipes[j],pipes[i]))
				{
					adjacencyList.get(i).add(j);
					adjacencyList.get(j).add(i);
				}
			}
		}
		
		if(IsBipartite(adjacencyList))
			System.out.println("possible");
		else
			System.out.println("impossible");
		
	}
	
	private static boolean IsBipartite(Map<Integer,ArrayList<Integer>> adjList){
		int vertices = adjList.size();
		// '0' :vertex is not colored, '1' : vertex color red, '2' : vertex color blue
		int[] color = new int[vertices];
		boolean[] visited = new boolean[vertices];
		color[0] = 1; //colored first vertex red
		Stack s = new Stack<Integer>();
		s.push(0);
		while(!s.isEmpty()){
			int cur = (Integer) s.pop();
			visited[cur] = true;
			for(int neighbor: adjList.get(cur)){
				if(!visited[neighbor])
				{
					if(color[cur] == 1)
						color[neighbor] = 2;
					if(color[cur] == 2)
						color[neighbor] = 1;
					s.push(neighbor);
				} else if (color[cur] == color[neighbor]){
					return false;
				}
			}
		}
		return true	;
	}
	
	private static boolean isIntersected(Segment seg1,Segment seg2){
		int ori1 = orientation(seg1.start,seg1.end,seg2.start);
		int ori2 = orientation(seg1.start,seg1.end,seg2.end);
		int ori3 = orientation(seg2.start,seg2.end,seg1.start);
		int ori4 = orientation(seg2.start,seg2.end,seg1.end);
		
		if(ori1 != ori2 && ori3 != ori4)
			return true;
		return false;
	}
	
	private static int orientation(Point p,Point q,Point r){
		int val = (q.y - p.y) * (r.x - q.x) - (r.y - q.y) * (q.x - p.x);
		
		return (val < 0 ? 1 : 2);
	}
	
	public static class Point{
		int x;
		int y;
		public Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static class Segment{
		Point start;
		Point end;
		int direction;
		public Segment(Point start,Point end){
			this.start = start;
			this.end = end;
		}
	}
	
}
