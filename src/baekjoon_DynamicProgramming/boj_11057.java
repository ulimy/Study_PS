package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_11057 {
	
	/*
	 ������ ���� ���� �ڸ��� ���������� �̷�� ���� ���Ѵ�. �̶�, ������ ���� ���Ƶ� ������������ ģ��.

	���� ���, 2234�� 3678, 11119�� ������ ��������, 2232, 3676, 91111�� ������ ���� �ƴϴ�.

	���� ���� N�� �־����� ��, ������ ���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ���� 0���� ������ �� �ִ�
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		int dp[][] = new int[num+1][10];
		for (int i=0;i<10;i++){
			dp[1][i]=1;
		}
		
		int mod = 10007;
		int sum = 0;
		
		for (int i=2;i<=num;i++){
			for (int j=0;j<10;j++){
				sum = (sum+dp[i-1][j])%mod;
				dp[i][j]=sum;
			}
			sum=0;
		}
		
		int result=0;
		for (int res:dp[num]){
			result = (result+res)%mod;
		}
		
		System.out.println(result%mod);
		
	}

}
