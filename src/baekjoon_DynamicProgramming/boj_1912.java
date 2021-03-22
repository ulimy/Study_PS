package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_1912 {
	
	/*
	 n개의 정수로 이루어진 임의의 수열이 주어진다. 
	 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 
	 단, 수는 한 개 이상 선택해야 한다.
	 
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] nums = new int[len];
		for (int i=0;i<len;i++){
			nums[i] = sc.nextInt();
		}
		sc.close();
		
		int dp[] = new int[len];
		dp[0] = nums[0];
		int max = nums[0];
		
		for (int i=1;i<len;i++){
			dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
			max = Math.max(dp[i], max);
		}
		
		System.out.println(max);
		
	}

}
