package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_1912 {
	
	/*
	 n���� ������ �̷���� ������ ������ �־�����. 
	 �츮�� �� �� ���ӵ� �� ���� ���� �����ؼ� ���� �� �ִ� �� �� ���� ū ���� ���Ϸ��� �Ѵ�. 
	 ��, ���� �� �� �̻� �����ؾ� �Ѵ�.
	 
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
