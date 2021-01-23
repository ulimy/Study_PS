package lecture_LinkedList;

public class ReverseLinkedList_0123 {
	
	// Linked list 뒤집기
	
	public ListNode solve(ListNode cur){
		// 맨 처음 노드를 맨 뒤로 보내고 뒤에서 앞으로 하나씩 추가해 간다고 생각하기
		ListNode next=null;
		ListNode prev=null;
		
		while(cur!=null){
			// 다음 노트를 next에 잠시 저장
			next = cur.next;
			// cur의 next는 prev로
			cur.next = prev;
			// 추가했으니 앞으로 한칸 이동
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
