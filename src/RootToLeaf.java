import java.util.*;;
public class RootToLeaf {
	
	public static int findTotalRootToLeaf(TreeNode root){
		int sum=0;
		int num=0;
		return findTotalRootToLeaf(root,sum,num);
	}
	
	public static int findTotalRootToLeaf(TreeNode root,int sum,int num){
		if(root==null)
			return 0;
		num = num*10+ root.val;
		if(root.left==null && root.right==null)
			return num;
		sum=findTotalRootToLeaf(root.left,sum,num)+findTotalRootToLeaf(root.right,sum,num);
		return sum;
		
	}
	
	public static void main(String[] args){
		TreeNode n1=new TreeNode(8);
		TreeNode n2=new TreeNode(4);
		TreeNode n3=new TreeNode(3);
		TreeNode n4=new TreeNode(1);
		TreeNode n5=new TreeNode(7);
		TreeNode n6=new TreeNode(0);
		TreeNode n7=new TreeNode(2);
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n2.right=n5;
		n3.left=n6;
		n5.left=n7;
		System.out.println(findTotalRootToLeaf(n1));
	}
}	
