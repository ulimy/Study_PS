package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_2193 {
	/*
	 0�� 1�θ� �̷���� ���� �������� �Ѵ�. �̷��� ������ �� Ư���� ������ ���� �͵��� �ִµ�, �̵��� ��ģ��(pinary number)�� �Ѵ�. ��ģ���� ������ ������ �����Ѵ�.

	��ģ���� 0���� �������� �ʴ´�.
	��ģ�������� 1�� �� �� �������� ��Ÿ���� �ʴ´�. ��, 11�� �κ� ���ڿ��� ���� �ʴ´�.
	���� ��� 1, 10, 100, 101, 1000, 1001 ���� ��ģ���� �ȴ�. ������ 0010101�̳� 101101�� ���� 1, 2�� ��Ģ�� ����ǹǷ� ��ģ���� �ƴϴ�.
	
	N(1 �� N �� 90)�� �־����� ��, N�ڸ� ��ģ���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		/* my solution
		long dp[][] = new long[num+1][2];
		dp[1][0]=0;
		dp[1][1]=1;
		
		for (int i=2;i<=num;i++){
			dp[i][0] = dp[i-1][0]+dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		
		long result = dp[num][0]+dp[num][1];
		*/
		
		// better solution
		long dp[] = new long[num+1];
		dp[0]=0;
		dp[1]=1;
		
		for (int i=2;i<=num;i++){
			// 0�� ��� - ���ڸ��� ���� ��� ���� -> i-1
			// 1�� ��� - ���ڸ��� 0�̾�߸� �� -> i-2
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		long result = dp[num];
		
		System.out.println(result);
	}

}
