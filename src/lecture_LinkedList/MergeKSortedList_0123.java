package lecture_LinkedList;

public class MergeKSortedList_0123 {

	// 여러개의 연결리스트 형태의 노트를 합쳐 정렬하기
	
	public ListNode solve(ListNode[] list){
		return null;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);

		ListNode[] list = new ListNode[3];
		list[0] = l1;
		list[1] = l2;
		list[2] = l3;
		
		MergeKSortedList_0123 a = new MergeKSortedList_0123();
		ListNode result = a.solve(list);
		
		while(result!=null){
			System.out.println(result.val);
			result=result.next;
		}
	}

}
