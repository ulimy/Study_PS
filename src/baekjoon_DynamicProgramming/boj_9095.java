package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_9095 {

	// 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
	// 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int nums[] = new int[count];
		int max=0;
		
		for (int i=0;i<count;i++){
			nums[i] = sc.nextInt();
			if(nums[i]>max) max=nums[i];
		}
		
		sc.close();
		
		int dp[] = new int[max+1];
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		
		if(max>3){
			for (int i=4;i<=max;i++){
				dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
			}
		}
		
		for (int num : nums){
			System.out.println(dp[num]);
		}

	}

}
