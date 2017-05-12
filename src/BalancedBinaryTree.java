
public class BalancedBinaryTree {
	public static boolean isBalanced(TreeNode root){
		boolean result = false;
		if(root==null)
			return true;
		if(isBalanced(root.left)&&isBalanced(root.right)
				&& Math.abs(findHeight(root.left)-findHeight(root.right))<=1)
			result = true;
		return result;
	}
	
	public static int findHeight(TreeNode root){
		if(root==null)
			return 0;
		return Math.max(findHeight(root.left), findHeight(root.right))+1;
	}
	
}
