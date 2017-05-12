
public class ConstructBinaryTree {
	public static TreeNode buildTree(int[] inOrder,int[] postOrder){
		int inStart=0;
		int postStart=0;
		int inEnd=inOrder.length-1;
		int postEnd=postOrder.length-1;
		return buildTree(inOrder,postOrder,inStart,postStart,inEnd,postEnd);
	}
	
	public static TreeNode buildTree(int[] inOrder,int[] postOrder,int inStart,int postStart,int inEnd,int postEnd){
		if(inStart == inEnd)
			return new TreeNode(inOrder[inStart]);
		int root_val=postOrder[postOrder.length-1];
		int root_pos = binarySearch(root_val,inOrder,inStart,inEnd);
		TreeNode root=new TreeNode(root_val);
		root.left= buildTree(inOrder,postOrder,inStart,postStart,root_pos-1,root_pos-1);
		root.right= buildTree(inOrder,postOrder,root_pos+1,root_pos,inEnd,postEnd-1);
		return root;
	}
	
	public static int binarySearch(int val,int[] a,int l,int r)
	{
		if(l==r)
			return l;
		int mid=(l+r)/2;
		if(val==a[mid])
			return mid;
		else if(val>a[mid])
			return binarySearch(val,a,mid+1,r);
		else
			return binarySearch(val,a,l,mid-1);
	}
}
