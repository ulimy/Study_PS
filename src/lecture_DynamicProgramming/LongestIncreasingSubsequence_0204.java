package lecture_DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence_0204 {

	// ������ ��ӵǴ� ������ ����
	
	public int solve(int[] nums){
		
		// ��üũ
		if (nums==null || nums.length==0) return 0;
		
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		
		for (int i=1;i<nums.length;i++){
			if(nums[i]>nums[i-1]){
				dp[i] = dp[i-1]+1;
			}else{
				dp[i] = dp[i-1];
			}
		}
		
		return dp[nums.length-1];
	}
	
	public static void main(String[] args) {
		LongestIncreasingSubsequence_0204 a = new LongestIncreasingSubsequence_0204();
		int[] nums = {1,2,3, 2, 5, 2, 6, 10, 4, 12}; 

		System.out.println(a.solve(nums));
	}

}
