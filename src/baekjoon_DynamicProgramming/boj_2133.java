package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_2133 {
	
	// 3��N ũ���� ���� 2��1, 1��2 ũ���� Ÿ�Ϸ� ä��� ����� ���� ���غ���.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		int[] dp = new int[num+1];
		dp[0]=1;

		for (int i=2;i<=num;i++){
			dp[i] = dp[i-2]*3;
			for (int j=i-4;j>=0;j-=2){
				dp[i]+=dp[j]*2;
			}
		}
		
		System.out.println(dp[num]);
	}

}
