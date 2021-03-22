package baekjoon_DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class boj_11722 {
	
	// 수열 A가 주어졌을 때, 가장 긴 감소하는 부분 수열을 구하는 프로그램을 작성하시오.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] nums = new int[len];
		for (int i=0;i<len;i++){
			nums[i] = sc.nextInt();
		}
		sc.close();
		
		int[] dp = new int[len];
		Arrays.fill(dp,1);
		
		for (int i=1;i<len;i++){
			for (int j=0;j<i;j++){
				if(nums[i]<nums[j]&&dp[i]<=dp[j]){
					dp[i] = dp[j]+1;
				}
			}
		}
		
		int max=0;
		for (int num : dp){
			if (max<num) max=num;
		}
		
		System.out.println(max);
	}

}
