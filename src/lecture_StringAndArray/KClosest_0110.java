package lecture_StringAndArray;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest_0110 {
	
	/*
	 원점으로부터 거리가 가장 짧은 순서대로 k개 찾아내기
	 
	 input : points = [[1,3],[-2,2]],k=1
	 output : [[-2,2]]
	 
	 PriorityQueue 이용하기!
	 
	 */

	public int[][] solve(int[][] points,int k){
		
		// 거리 오름차순으로 queue 구성
		Queue<int[]> queue = new PriorityQueue<>(points.length,(a,b)->(a[0]^2+a[1]^2)-(b[0]^2+b[1]^2));
		int[][] result = new int[k][2];
		int index=0;
		
		// PriorityQueue에 담기
		for (int[] p : points){
			queue.offer(p);
		}
		
		// 결과값 반환 할 배열에 담기
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
