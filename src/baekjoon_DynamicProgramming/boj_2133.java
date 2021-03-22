package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_2133 {
	
	// 3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.

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
