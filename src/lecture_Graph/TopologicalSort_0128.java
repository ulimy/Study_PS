package lecture_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort_0128 {
	
	// 각 요소들의 선행 순서를 위배하지 않도록 정렬하기 - 선수과목을 위배하지 않는 수강 순서 정렬
	
	public boolean solve(int courseNumber, int[][] nums) {
		
		//에러처리
		if(courseNumber<=0) return false;
		
		Queue<Integer> queue = new LinkedList<>();
		int[] inDegree = new int[courseNumber];
		
		int numsLength = nums.length;
		
		// inDegree 1로 초기화
		for (int i=0;i<nums.length;i++){
			inDegree[nums[i][1]]++;
		}
		
		// 큐에 넣고 3 찾기 
		for(int i=0;i<inDegree.length;i++){
			if(inDegree[i]==0){
				queue.offer(i);
			}
		}
		
		while (!queue.isEmpty()) {
			// 큐에서 뽑아서
			int zeroVal = queue.poll();
			// 뽑은 값이 나오는 경우 찾기
			for (int i = 0; i < numsLength; i++) {
				if (zeroVal == nums[i][0]) {
					// 찾았다면 --해주기
					inDegree[nums[i][1]]--;
					if (inDegree[nums[i][1]] == 0)
						// 0이면 끝! 새로운 값 offer 해주기
						queue.offer(nums[i][1]);
				}
			}
		}
		
		// 모두 0이 맞는지 확인
		for (int i=0;i<inDegree.length;i++) {
			if (inDegree[i] != 0)
				return false;
		}
		
		return true;

	}

	public static void main(String[] args) {
		TopologicalSort_0128 a = new TopologicalSort_0128();
		
		// 수강 할 과목 수(0,1,2,3)
		int course = 4;
		int[][] nums = { { 1, 0 }, 
				         { 2, 1 },
				         { 3, 2 } };
		
		System.out.println(a.solve(course, nums));

	}

}
