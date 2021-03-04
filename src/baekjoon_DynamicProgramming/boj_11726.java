package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_11726 {

	// 2��n ũ���� ���簢���� 1��2, 2��1 Ÿ�Ϸ� ä��� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		sc.close();
		
		int dp[] = new int[x+1];
		dp[0]=0;
		dp[1]=1;
		if (x>=2) dp[2]=2;
		
		for (int i=3;i<=x;i++){
			dp[i] = (dp[i-1]+dp[i-2])%10007;
		}
		
		System.out.println(dp[x]);
	}

}
