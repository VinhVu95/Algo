import java.util.*;

public class PreOrderSolution {
	public ArrayList<Integer> preOrder(TreeNode root){
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(root==null)
			return result;
		Stack<TreeNode> lst=new Stack<TreeNode>();
		lst.push(root);
		while(!lst.isEmpty())
		{
			 TreeNode temp=lst.pop();
			 result.add(temp.val);
			 if(temp.left!=null)
				 lst.push(temp.left);
			 else if(temp.right!=null)
				 lst.push(temp.right);
		}
		return result;
	}
}
