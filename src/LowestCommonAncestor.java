
public class LowestCommonAncestor {
	public TreeNode findLowestCommonAncestor(TreeNode root,TreeNode p, TreeNode q){
		if(root==null)
			return null;
		if(root.left==p || root.left==q || root.right==p || root.right==q)
			return root;
		TreeNode left=findLowestCommonAncestor(root.left,p,q);
		TreeNode right=findLowestCommonAncestor(root.right,p,q);
		if(left==null && right ==null)
			return root;
		else if(left==null)
			return root.right;
		else
			return root.left;	
	}
}
