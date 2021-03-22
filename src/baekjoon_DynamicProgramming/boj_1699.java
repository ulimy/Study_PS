package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_1699 {

	// �־��� �ڿ��� N�� �̷��� ���������� ������ ǥ���� ���� �� ���� �ּҰ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
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
