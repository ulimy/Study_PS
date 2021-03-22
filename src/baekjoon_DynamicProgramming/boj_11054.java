package baekjoon_DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class boj_11054 {
	
	//수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] nums = new int[len];
		for (int i=0;i<len;i++){
			nums[i] = sc.nextInt();
		}
		sc.close();

		int[] dp_up = new int[len];
		int[] dp_down = new int[len];
		Arrays.fill(dp_up, 1);
		Arrays.fill(dp_down, 1);
		
		for (int i=0;i<len;i++){
			for (int j=0;j<i;j++){
				if(nums[i]>nums[j]&&dp_up[i]<=dp_up[j]){
					dp_up[i] = dp_up[j]+1;
				}
			}
		}
		
		for (int i=len-1;i>=0;i--){
			for (int j=len-1;j>i;j--){
				if(nums[i]>nums[j]&&dp_down[i]<=dp_down[j]){
					dp_down[i] = dp_down[j]+1;
				}
			}
		}
		
		int max=0;
		for (int i=0;i<len;i++){
			max = Math.max(max,dp_up[i]+dp_down[i]);
		}

		System.out.println(max-1);
		
	}
}
