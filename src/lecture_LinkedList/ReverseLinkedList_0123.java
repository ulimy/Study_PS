package lecture_LinkedList;

public class ReverseLinkedList_0123 {
	
	// Linked list ������
	
	public ListNode solve(ListNode cur){
		// �� ó�� ��带 �� �ڷ� ������ �ڿ��� ������ �ϳ��� �߰��� ���ٰ� �����ϱ�
		ListNode next=null;
		ListNode prev=null;
		
		while(cur!=null){
			// ���� ��Ʈ�� next�� ��� ����
			next = cur.next;
			// cur�� next�� prev��
			cur.next = prev;
			// �߰������� ������ ��ĭ �̵�
			prev=cur;
			cur = next;
		}
		
		return prev;
	}
	
	public void printNode(ListNode head) {
		System.out.println("printNOde: ");
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		
		ReverseLinkedList_0123 a = new ReverseLinkedList_0123();
		a.printNode(a.solve(l1));
		
	}

}