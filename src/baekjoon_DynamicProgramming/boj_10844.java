package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_10844 {

	/*
	 45656�̶� ���� ����.

	�� ���� ������ ��� �ڸ����� ���̰� 1�� ����. �̷� ���� ��� ����� �Ѵ�.

	�����̴� ���� ���̰� N�� ��� ���� �� �� �ִ��� �ñ�������.

	N�� �־��� ��, ���̰� N�� ��� ���� �� �� �� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. (0���� �����ϴ� ���� ����.)*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		long dp[][] = new long[num+1][10];
		sc.close();
		
		dp[1][0]=0;
		for (int i=1;i<10;i++){
			dp[1][i]=1;
		};
		
		long mod = 1000000000;
		
		for (int i=2;i<=num;i++){
			
			for (int j=0;j<10;j++){
				
				if(j==0){
					dp[i][0]=dp[i-1][1]%mod;
				}else if(j==9) {
					dp[i][9]=dp[i-1][8]%mod;
				}else{
					dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%mod;
				}
			}
		}

		long result=0;
		for (long res : dp[num]) result = result+res;
		
		System.out.println(result%mod);

	}

}
