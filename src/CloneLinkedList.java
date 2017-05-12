import java.util.ArrayList;

public class CloneLinkedList {
	public static void main(String[] args){
		ListNode n1= new ListNode(1);
		ListNode n2= new ListNode(2);
		ListNode n3= new ListNode(3);
		ListNode n4= new ListNode(4);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		//n1.arbit=n3;
		//n2.arbit=n1;
		//n3.arbit=n4;
		//n4.arbit=n2;
		ListNode r1= clone(n1);
		ListNode r2= r1.next;
		ListNode r3= r2.next;
		ListNode r4= r3.next;
		//System.out.println(r2.val+" "+r3.val+" "+r2.arbit.val);
	}
	
	public static ListNode clone(ListNode head){
			if(head==null)
				return null;
			ArrayList<ListNode> store= new ArrayList<ListNode>();
			int count=0;
			ListNode p=head;
			ListNode head_copy=new ListNode(p.val);
			ListNode q=head_copy;
			try{
				while(p!=null)
			{
				ListNode temp= new ListNode(p.next.val);
				q.next=temp;
				//q.arbit=p;
				store.add(p.next);
				count++;
				q=q.next;
				p=p.next;
			}
			q=head_copy;
			p=head;
			while(q!=null)
			{
				ListNode temp=p.next;
				p.next=q;
				p=temp;
				q=q.next;
			}
			q=head_copy;
			p=head;
			while(q!=null)
			{
				//q.arbit=q.arbit.arbit.next;
				q=q.next;
			}
			q=head_copy;
			p=head;
			for( int i=0;i<count;i++)
			{
				p.next=store.get(i);
				p=p.next;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return head_copy;
	}
}
