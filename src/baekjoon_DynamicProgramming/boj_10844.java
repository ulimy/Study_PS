package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_10844 {

	/*
	 45656이란 수를 보자.

	이 수는 인접한 모든 자리수의 차이가 1이 난다. 이런 수를 계단 수라고 한다.

	세준이는 수의 길이가 N인 계단 수가 몇 개 있는지 궁금해졌다.

	N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)*/
	
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
