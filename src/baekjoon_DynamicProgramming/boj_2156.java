package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_2156 {
	
	/*
	 ȿ�ִ� ������ �ý��� �Ϸ��� �ϴµ�, ���⿡�� ������ ���� �� ���� ��Ģ�� �ִ�.

	1. ������ ���� �����ϸ� �� �ܿ� ����ִ� �����ִ� ��� ���ž� �ϰ�, ���� �Ŀ��� ���� ��ġ�� �ٽ� ���ƾ� �Ѵ�.
	2. �������� ���� �ִ� 3���� ��� ���� ���� ����.
	
	ȿ�ִ� �� �� �ִ� ��� ���� ���� �����ָ� ������ ���ؼ� � ������ ���� �����ؾ� ���� ����ϰ� �ִ�. 
	1���� n������ ��ȣ�� �پ� �ִ� n���� ������ ���� ������� ���̺� ���� ���� �ְ�, 
	�� ������ �ܿ� ����ִ� �������� ���� �־����� ��, 
	ȿ�ָ� ���� ���� ���� ���� �����ָ� ���� �� �ֵ��� �ϴ� ���α׷��� �ۼ��Ͻÿ�. 
	*/

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] wine = new int[len];
		for (int i=0;i<len;i++){
			wine[i] = sc.nextInt();
		}
		sc.close();
		
		int[] dp = new int[len];
		if (len>=1){
			dp[0] = wine[0];
		}
		if (len>=2){
			dp[1] = wine[0]+wine[1];
		}
		if (len>=3){
			dp[2] = Math.max(dp[1],Math.max(wine[0]+wine[2], wine[1]+wine[2]));
		}
		
		for(int i=3;i<len;i++){
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+wine[i],dp[i-3]+wine[i-1]+wine[i]));
		}

		System.out.println(dp[len-1]);
	}

}
