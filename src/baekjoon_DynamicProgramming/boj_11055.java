package baekjoon_DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class boj_11055 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] nums = new int[len];
		for (int i=0;i<len;i++){
			nums[i] = sc.nextInt();
		}
		sc.close();
		
		int[] dp = new int[len];
		dp[0] = nums[0];
		
		for (int i=0;i<len;i++){
			dp[i] = nums[i];
			for (int j=0;j<i;j++){
				if(nums[i]>nums[j]&&dp[i]<dp[j]+nums[i]){
					dp[i] = dp[j]+nums[i];
				}
			}
		}
		
		System.out.println(Arrays.toString(dp));
		
		
		int result=0;
		for (int num : dp){
			if (num>result) result=num;
		}
		
		System.out.println(result);

	}

}
