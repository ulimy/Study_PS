package lecture_LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedList_0123 {

	/* 여러개의 연결리스트 형태의 노트를 합쳐 정렬하기
	 
	 Priority Queue 이용하기!
	 
	 */
	
	public ListNode solve(ListNode[] list){
		// 오름차순 Priority Queue 만들기
		PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
		
		// 시작노드 임의로 0을 넣어 만들기
		ListNode newHead = new ListNode(0); 
		// 데이터 조작 방지를 위해 복사하여 사용
		ListNode p = newHead;
		
		// list 안에 들어있는 노드들 큐에 넣기
		for (ListNode node : list){
			if(node!=null){
				pq.offer(node);
			}
		}
		
		// 비어있지 않다면
		while(!pq.isEmpty()){
			// pq에 있는 노트 뽑아서
			ListNode node = pq.poll();
			// 결과를 담을 p에 추가
			p.next = node;
			// 다음 추가를 위해 뒤로 이동
			p = p.next;
			
			// 다음 노드를 pq에 추가
			if(node.next!=null){
				pq.offer(node.next);
			}
		}
		
		// 맨 처음은 더미로 0 넣었으므로 그 다음 노드 리턴
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
