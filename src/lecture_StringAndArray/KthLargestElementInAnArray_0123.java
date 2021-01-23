package lecture_StringAndArray;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray_0123 {
	
	/* k��°�� ���� ū �� ���ϱ�
	 
	 <solve_1>
	 �迭 ������������ �����Ͽ� ���ϱ�
	 
	 <solve_2>
	 Priority Queue �̿��ϱ�
	 
	 Priority Queue�� ������ �׻� k�� ��ŭ�� �����ϵ��� �ϸ鼭 �־��� �迭 �� ���Ҹ� �ϳ��� ����
	 -> k���� �Ѿ�� poll�� ��������
	 
	 ������ �� �� poll ���ָ� �װ� �ٷ� result
	 */
	
	// �迭����
	public int solve_1(int[] nums, int k){
		Arrays.sort(nums);
		return nums[nums.length-k] ;
	}
	
	// Priority Queue
	public int solve_2(int[] nums, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->a-b);
		
		for (int num : nums){
			pq.offer(num);
			if (pq.size()>k){
				pq.poll();
			}
		}
		
		return pq.poll();
	}
	
	public static void main(String[] args){
		KthLargestElementInAnArray_0123 a = new KthLargestElementInAnArray_0123();
		int[] nums = {3,2,1,5,6,4};
		int k =2;
		System.out.println(a.solve_1(nums, k));
		System.out.println(a.solve_2(nums, k));
	}

}
