package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_9095 {

	// ���� 4�� 1, 2, 3�� ������ ��Ÿ���� ����� �� 7������ �ִ�. ���� ��Ÿ�� ���� ���� 1�� �̻� ����ؾ� �Ѵ�.
	// ���� n�� �־����� ��, n�� 1, 2, 3�� ������ ��Ÿ���� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
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
