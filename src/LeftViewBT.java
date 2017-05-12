import java.util.*;
public class LeftViewBT {
	public List<TreeNode> leftViewList(TreeNode root){
		if(root==null)
			return null;
		List<TreeNode> result=new ArrayList<TreeNode>();
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		q.add(root);
		while(q.size()>0)
		{
			for(int i=0;i<q.size();i++)
			{
				TreeNode top=q.remove();
				if(i==0)
					result.add(top);
				if(top.left!=null)
					q.add(top.left);
				if(top.right!=null)
					q.add(top.right);
			}
		}
		return result;
	}
}
