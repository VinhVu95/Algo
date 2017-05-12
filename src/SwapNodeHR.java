import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SwapNodeHR {

    public static ArrayList<Integer> swapNode(TreeNode root,int k){
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode rt = root;
        ArrayList<Integer> output = new ArrayList<Integer>();
        //s.push(rt);
        while(!s.isEmpty() || rt != null)
        {
           if(rt != null)
           {
               if(rt.depth % k == 0)
                   {
                        TreeNode temp = rt.right;
                        rt.right = rt.left;
                        rt.left = temp;
                   }
               if(rt.left != null)
            	   rt.left.depth = rt.depth + 1;
               s.push(rt);
               rt = rt.left;
               
           } else
           {
               TreeNode curr = s.pop();
               //System.out.println(curr.value);
               output.add(curr.value);
               rt = curr.right;
               if(rt != null)
            	   rt.depth = curr.depth + 1;
           }
        }
        return output;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner scan = new Scanner(System.in);
    	int N = scan.nextInt();
    	Map<Integer,TreeNode> m = new HashMap<Integer,TreeNode>();
    	for(int i = 1;i <= N; i++)
    	{
    		TreeNode node = new TreeNode(i);
    		if(i == 1) node.depth = 1;
    		m.put(i,node);
    		int l = scan.nextInt();
    		int r = scan.nextInt();
    		if(l != -1) node._left = l;
    		if(r != -1) node._right = r;
    	}
    	
    	for(int i = 1; i <= N; i++)
    	{
    		TreeNode n= m.get(i);
    		if(n._left != 0) n.left = m.get(n._left);
    		if(n._right != 0) n.right = m.get(n._right);
    		//System.out.println("node :" + i + " left: " + n.left.value + " right: " + n.right.value);
    	}
    	int T = scan.nextInt();
    	List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
    	for(int j =1; j<=T ;j++){
    		int K = scan.nextInt();
    		result.add(swapNode(m.get(1),K));
    	}
    	//List<Integer> out = swapNode(m.get(1), 2);
    	for(int j = 0;j < T; j++){
    		ArrayList<Integer> out = result.get(j);
    		for(int c : out)
        	{
        		System.out.print(c + " ");
        	}
        	System.out.print("\n");

    	}
    }
    
    public static class TreeNode{
    	public int _left;
    	public int _right;
        public TreeNode left;
        public TreeNode right;
        public int value;
        public int depth;
        public TreeNode(int value){
            this.value = value;
        }
    }
}