
public class MaximumPathSum {
	public static int maxPathSum(TreeNode root){
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		calculatePathMax(root,max);
		return max[0];
	}
	
	public static int calculatePathMax(TreeNode root,int[] max_val){
		if(root==null)
			return 0;
		int left = calculatePathMax(root.left, max_val);
		int right = calculatePathMax(root.right,max_val);
		int result = Math.max(root.val,Math.max(root.val+left, root.val+right));
		max_val[0] = Math.max(max_val[0],Math.max(result,root.val+left+right));
		return result;
	}
}
