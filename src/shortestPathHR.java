import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class shortestPathHR {

    public static class Node{
        public int value;
        public ArrayList<Node> adjacencyList;
        public boolean visited;
        public int distance;
        
        public Node(int value){
            this.value = value;
            this.adjacencyList = new ArrayList<Node>();
            this.distance = 0;
        }
        
        public void addNeighbour(Node node){
            adjacencyList.add(node);
        }
        
    } 
    
    public static int[] shortestPaths(Node start,Node[] nodes){
        ArrayList<Node> queue = new ArrayList<Node>();
        queue.add(start);
        int[] result = new int[nodes.length];
        while(!queue.isEmpty()){
            Node head = queue.remove(0);
            for(Node neighbor: head.adjacencyList){
                if(!neighbor.visited)
                    {
                        neighbor.distance = head.distance + 6;
                        neighbor.visited = true;
                        queue.add(neighbor);
                    }
            }
        }
        for(int i = 1;i < result.length;i++)
        {
            if(i != start.value)
                {
                    if(nodes[i] != null)
                        result[i] = nodes[i].distance;
                    else
                        result[i] = -1;
                }
        }
        return result;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        int[][] results = new int[q][];
        for(int i =0; i < q;i++)
        {
            int n = scan.nextInt();
            int m = scan.nextInt();
            Node[] listNode = new Node[n+1];
            for(int j =0; j < m;j++)
            {
               int v = scan.nextInt();
               int u = scan.nextInt();
               if(listNode[v] == null )
               {          
                   listNode[v] = new Node(v); 
               }
                if(listNode[u] == null )
               {
                    listNode[u] = new Node(u);
               }
               listNode[v].addNeighbour(listNode[u]);
               listNode[u].addNeighbour(listNode[v]);
            }
            int s = scan.nextInt();
            results[i] = shortestPaths(listNode[s],listNode);
        }
        for(int i =0;i < q;i++)
            {
             for (int j =0;j < results[i].length; j++)
             {
            	 if(results[i][j] != 0)
                    System.out.print(results[i][j] + " ");
             }
            System.out.print("\n");
        }
    }
}
