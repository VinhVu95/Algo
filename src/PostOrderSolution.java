import java.util.*;
public class PostOrderSolution {
	public static void main(String[] args){
		TreeNode n1=new TreeNode(1);
		TreeNode n2=new TreeNode(2);
		TreeNode n3=new TreeNode(3);
		TreeNode n4=new TreeNode(4);
		TreeNode n5=new TreeNode(5);
		TreeNode n6=new TreeNode(6);
		TreeNode n7=new TreeNode(7);
		n1.left=n2;
		n1.right=n3;
		n2.right=n4;
		n3.left=n5;
		n3.right=n6;
		n6.left=n7;
		List<TreeNode> r= postOrder(n1);
		for(int i=0;i<r.size();i++)
		{
			System.out.println(r.get(i).val);
		}
	}
	public static ArrayList<TreeNode> postOrder(TreeNode root){
		if(root==null)
			return null;
		Stack<TreeNode> stk=new Stack<TreeNode>();
		//stk.push(root);
		List<TreeNode> result= new ArrayList<TreeNode>(1000);
		TreeNode p=root;
		stk.push(p);
		try{
		while(!stk.isEmpty())
		{
			if(p.right!=null && p.left!=null)
			{
				stk.push(p.right);
				stk.push(p.left);
				p=p.left;
			}
			else if(p.left!=null)
			{
				stk.push(p.left);
				p=p.left;
			}
			else if(p.right!=null)
			{
				stk.push(p.right);
				p=p.right;
			}
			else
			{
				TreeNode r=stk.pop();
				result.add(r);
				p=stk.peek();
			}
		}
		
		} catch(Exception ex) {
			ex.printStackTrace();
		}
			return (ArrayList<TreeNode>) result;
		}
}
