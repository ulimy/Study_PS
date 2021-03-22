package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_2156 {
	
	/*
	 효주는 포도주 시식을 하려고 하는데, 여기에는 다음과 같은 두 가지 규칙이 있다.

	1. 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
	2. 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
	
	효주는 될 수 있는 대로 많은 양의 포도주를 맛보기 위해서 어떤 포도주 잔을 선택해야 할지 고민하고 있다. 
	1부터 n까지의 번호가 붙어 있는 n개의 포도주 잔이 순서대로 테이블 위에 놓여 있고, 
	각 포도주 잔에 들어있는 포도주의 양이 주어졌을 때, 
	효주를 도와 가장 많은 양의 포도주를 마실 수 있도록 하는 프로그램을 작성하시오. 
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
