
public class SwapNode {
	public static void main( String[] args){
		ListNode n1= new ListNode(1);
		ListNode n2= new ListNode(2);
		ListNode n3= new ListNode(3);
		ListNode n4= new ListNode(4);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		
		
		
			System.out.println(swapNode(n1).val);
			
		
	}
	public static ListNode swapNode(ListNode head){
		if(head==null || head.next==null)
			return head;
		ListNode p1=head;
		ListNode p2=head.next;
		while(p1!=null && p2!=null)
		{
			ListNode temp =p2.next;
			p2.next=p1;
			p1.next=temp;
			p1=p1.next;
			p2=p1.next.next;
		}
		return head.next;
	}
}
