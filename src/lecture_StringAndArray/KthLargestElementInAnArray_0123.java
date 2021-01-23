package lecture_StringAndArray;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray_0123 {
	
	/* k번째로 제일 큰 값 구하기
	 
	 <solve_1>
	 배열 오름차순으로 정렬하여 구하기
	 
	 <solve_2>
	 Priority Queue 이용하기
	 
	 Priority Queue의 개수를 항상 k개 만큼만 유지하도록 하면서 주어진 배열 속 원소를 하나씩 넣음
	 -> k개를 넘어가면 poll로 빼버리기
	 
	 끝나고 난 뒤 poll 해주면 그게 바로 result
	 */
	
	// 배열정렬
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
