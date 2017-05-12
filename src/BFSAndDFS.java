import java.util.*;
public class BFSAndDFS {
	class Graph{
		public int num_vertices;
		public Map<Integer,List<Integer>> adjacencyList;
		public Graph(int num){
			num_vertices=num;
			adjacencyList=new HashMap<Integer,List<Integer>>();
			for(int i=0;i<num;i++)
				adjacencyList.put(i, new LinkedList<Integer>());
		}
		public void setEdge(int from,int to){
			adjacencyList.get(from).add(to);
			adjacencyList.get(to).add(from);
		}
		
	}
	
	public void BFS(Graph g,int start){
		boolean[] isVisited=new boolean[g.num_vertices];
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(start);
		isVisited[start]=true;
		while(!q.isEmpty()){
			int k = q.remove();
			for(int adjacent:g.adjacencyList.get(k))
			{
				if(!isVisited[adjacent])
					{
						q.add(adjacent);
						isVisited[adjacent]=true;
					}
			}
		}
	}
	
	public void DFS(Graph g,int start){
		boolean[] isVisited=new boolean[g.num_vertices];
		//Stack<Integer> s=new Stack<Integer>();
		DFS_recursive(g,start,isVisited);
	}
	
	public void DFS_recursive(Graph g,int start,boolean[] isVisited){
		isVisited[start]=true;
		//s.push(start);
		for(int adjacent:g.adjacencyList.get(start))
		{
			if(!isVisited[adjacent])
				DFS_recursive(g,adjacent,isVisited);
		}
		//s.pop();
	}
	
	public void DFS_nonrecursive(Graph g,int start){
		boolean[] isVisited=new boolean[g.num_vertices];
		Stack<Integer> s=new Stack<Integer>();
		s.push(start);
		//isVisited[start]=true;
		while(!s.isEmpty())
		{
			int p=s.pop();
			isVisited[p]=true;
			for(int adjacent:g.adjacencyList.get(p))
			{
				if(!isVisited[adjacent])
					{
						s.push(adjacent);
						//isVisited[adjacent]=true;
					}
			}
		}
	}
}
