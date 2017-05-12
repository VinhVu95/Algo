import java.util.*;

public class InOrderSolution {
	public ArrayList<Integer> inOrder(TreeNode root){
		ArrayList<Integer> result=new ArrayList<Integer>();
		if (root==null)
			return result;
		Stack<TreeNode> stk=new Stack<TreeNode>();
		TreeNode p=root;
		while(!stk.isEmpty() || p!=null)
			{
				if(p!=null)
				{
					stk.push(p);
					p=p.left;
				}
				else
				{
					TreeNode temp=stk.pop();
					result.add(temp.val);
					p=temp.right;
				}
			}
		return result;
	}
}
