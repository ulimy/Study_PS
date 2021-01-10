package lecture_StringAndArray;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest_0110 {
	
	/*
	 �������κ��� �Ÿ��� ���� ª�� ������� k�� ã�Ƴ���
	 
	 input : points = [[1,3],[-2,2]],k=1
	 output : [[-2,2]]
	 
	 PriorityQueue �̿��ϱ�!
	 
	 */

	public int[][] solve(int[][] points,int k){
		
		// �Ÿ� ������������ queue ����
		Queue<int[]> queue = new PriorityQueue<>(points.length,(a,b)->(a[0]^2+a[1]^2)-(b[0]^2+b[1]^2));
		int[][] result = new int[k][2];
		int index=0;
		
		// PriorityQueue�� ���
		for (int[] p : points){
			queue.offer(p);
		}
		
		// ����� ��ȯ �� �迭�� ���
		while(index<k){
			result[index] = queue.poll();
			index++;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		KClosest_0110 a = new KClosest_0110();
		int[][] input = {{1,3},{-2,2}};
		System.out.println(Arrays.deepToString(a.solve(input,1)));

	}

}
