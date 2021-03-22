package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_1699 {

	// 주어진 자연수 N을 이렇게 제곱수들의 합으로 표현할 때에 그 항의 최소개수를 구하는 프로그램을 작성하시오.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		int[] dp = new int[num+1];
		dp[0]=0;
		
		for (int i=1;i<=num;i++){
			dp[i] = i;
			for (int j=1;j*j<=i;j++){
				dp[i] = Math.min(dp[i], dp[i-(j*j)]+1);
			}
		}
		
		System.out.println(dp[num]);
		
	}

}
