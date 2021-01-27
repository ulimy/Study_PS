package lecture_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort_0128 {
	
	// �� ��ҵ��� ���� ������ �������� �ʵ��� �����ϱ� - ���������� �������� �ʴ� ���� ���� ����
	
	public boolean solve(int courseNumber, int[][] nums) {
		
		//����ó��
		if(courseNumber<=0) return false;
		
		Queue<Integer> queue = new LinkedList<>();
		int[] inDegree = new int[courseNumber];
		
		int numsLength = nums.length;
		
		// inDegree 1�� �ʱ�ȭ
		for (int i=0;i<nums.length;i++){
			inDegree[nums[i][1]]++;
		}
		
		// ť�� �ְ� 3 ã�� 
		for(int i=0;i<inDegree.length;i++){
			if(inDegree[i]==0){
				queue.offer(i);
			}
		}
		
		while (!queue.isEmpty()) {
			// ť���� �̾Ƽ�
			int zeroVal = queue.poll();
			// ���� ���� ������ ��� ã��
			for (int i = 0; i < numsLength; i++) {
				if (zeroVal == nums[i][0]) {
					// ã�Ҵٸ� --���ֱ�
					inDegree[nums[i][1]]--;
					if (inDegree[nums[i][1]] == 0)
						// 0�̸� ��! ���ο� �� offer ���ֱ�
						queue.offer(nums[i][1]);
				}
			}
		}
		
		// ��� 0�� �´��� Ȯ��
		for (int i=0;i<inDegree.length;i++) {
			if (inDegree[i] != 0)
				return false;
		}
		
		return true;

	}

	public static void main(String[] args) {
		TopologicalSort_0128 a = new TopologicalSort_0128();
		
		// ���� �� ���� ��(0,1,2,3)
		int course = 4;
		int[][] nums = { { 1, 0 }, 
				         { 2, 1 },
				         { 3, 2 } };
		
		System.out.println(a.solve(course, nums));

	}

}
