package lecture_LinkedList;

// 두 연결리스트의 숫자를 더하기

class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x){
		this.val = x;
	}
}

public class AddTwoNumbers_0123 {
	
	public ListNode solve(ListNode l1, ListNode l2){
		return null;
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
