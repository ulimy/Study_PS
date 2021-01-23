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
		// 데이터 조작 방지를 위해 받은 그대로를 쓰지 않고 복사하여 사용
		ListNode newHead = new ListNode(0);
		ListNode p1=l1, p2=l2, p3=newHead;
		int carry=0;
		
		while(p1!=null && p2!=null){
			if(p1!=null){
				// p1값 더하고
				carry+=p1.val;
				// 다음 노드로 넘어가기
				p1=p1.next;
			}
			// p2도 똑같이 반복
			if(p2!=null){
				carry+=p2.val;
				p2=p2.next;
			}
			
			// 더한 값 p3에 추가하기
			p3.next=new ListNode(carry%10);
			p3=p3.next;
			
			// carry가 10 이상이면 몫을 다음 자릿수로 넘겨주기
			carry/=10;
		}
		
		// while문 끝났는데 carry가 1이라면 자릿수 초과됨. 하나 더 만들어주기
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
