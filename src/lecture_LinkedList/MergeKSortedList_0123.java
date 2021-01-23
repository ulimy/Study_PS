package lecture_LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedList_0123 {

	/* �������� ���Ḯ��Ʈ ������ ��Ʈ�� ���� �����ϱ�
	 
	 Priority Queue �̿��ϱ�!
	 
	 */
	
	public ListNode solve(ListNode[] list){
		// �������� Priority Queue �����
		PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
		
		// ���۳�� ���Ƿ� 0�� �־� �����
		ListNode newHead = new ListNode(0); 
		// ������ ���� ������ ���� �����Ͽ� ���
		ListNode p = newHead;
		
		// list �ȿ� ����ִ� ���� ť�� �ֱ�
		for (ListNode node : list){
			if(node!=null){
				pq.offer(node);
			}
		}
		
		// ������� �ʴٸ�
		while(!pq.isEmpty()){
			// pq�� �ִ� ��Ʈ �̾Ƽ�
			ListNode node = pq.poll();
			// ����� ���� p�� �߰�
			p.next = node;
			// ���� �߰��� ���� �ڷ� �̵�
			p = p.next;
			
			// ���� ��带 pq�� �߰�
			if(node.next!=null){
				pq.offer(node.next);
			}
		}
		
		// �� ó���� ���̷� 0 �־����Ƿ� �� ���� ��� ����
		return newHead.next;
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
