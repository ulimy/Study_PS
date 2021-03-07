package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_11057 {
	
	/*
	 오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.

	예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.

	수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다
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
