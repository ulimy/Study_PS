package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_1463 {
	
	/*
	���� X�� ����� �� �ִ� ������ ������ ���� �� ���� �̴�.

	1. X�� 3���� ������ ��������, 3���� ������.
	2. X�� 2�� ������ ��������, 2�� ������.
	3. 1�� ����.
	
	���� N�� �־����� ��, ���� ���� ���� �� ���� ������ ����ؼ� 1�� ������� �Ѵ�. 
	������ ����ϴ� Ƚ���� �ּڰ��� ����Ͻÿ�.
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		sc.close();
		
		int dp[] = new int[x+1];
		dp[0]=0;
		dp[1]=0;
		
		for (int i=2;i<=x;i++){
			dp[i]=dp[i-1]+1;
			if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1);
			if(i%2==0) dp[i] = Math.min(dp[i],dp[i/2]+1);
		}
		
		System.out.println(dp[x]);
		
	}

}
