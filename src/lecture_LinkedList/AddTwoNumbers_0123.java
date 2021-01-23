package lecture_LinkedList;

// �� ���Ḯ��Ʈ�� ���ڸ� ���ϱ�

class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x){
		this.val = x;
	}
}

public class AddTwoNumbers_0123 {
	
	public ListNode solve(ListNode l1, ListNode l2){
		// ������ ���� ������ ���� ���� �״�θ� ���� �ʰ� �����Ͽ� ���
		ListNode newHead = new ListNode(0);
		ListNode p1=l1, p2=l2, p3=newHead;
		int carry=0;
		
		while(p1!=null && p2!=null){
			if(p1!=null){
				// p1�� ���ϰ�
				carry+=p1.val;
				// ���� ���� �Ѿ��
				p1=p1.next;
			}
			// p2�� �Ȱ��� �ݺ�
			if(p2!=null){
				carry+=p2.val;
				p2=p2.next;
			}
			
			// ���� �� p3�� �߰��ϱ�
			p3.next=new ListNode(carry%10);
			p3=p3.next;
			
			// carry�� 10 �̻��̸� ���� ���� �ڸ����� �Ѱ��ֱ�
			carry/=10;
		}
		
		// while�� �����µ� carry�� 1�̶�� �ڸ��� �ʰ���. �ϳ� �� ������ֱ�
		if(carry==1) p3.next = new ListNode(1);
		
		return newHead.next;
	}


	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(2);
		
		AddTwoNumbers_0123 a = new AddTwoNumbers_0123();
		ListNode node = a.solve(l1,l2);
		
		while(node!=null) {
			System.out.println(node.val);
			node = node.next;
		}

	}
}
