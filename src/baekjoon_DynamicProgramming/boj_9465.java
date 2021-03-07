package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_9465 {

	/*
	 상근이의 여동생 상냥이는 문방구에서 스티커 2n개를 구매했다. 스티커는 2행 n열로 배치되어 있다. 
	 상냥이는 스티커를 이용해 책상을 꾸미려고 한다.

	상냥이가 구매한 스티커의 품질은 매우 좋지 않다. 스티커 한 장을 떼면, 그 스티커와 변을 공유하는 스티커는 모두 찢어져서 사용할 수 없게 된다. 
	즉, 뗀 스티커의 왼쪽, 오른쪽, 위, 아래에 있는 스티커는 사용할 수 없게 된다.
	 모든 스티커를 붙일 수 없게된 상냥이는 각 스티커에 점수를 매기고, 점수의 합이 최대가 되게 스티커를 떼어내려고 한다. 먼저, 각 스티커에 점수를 매겼다. 
	 상냥이가 뗄 수 있는 스티커의 점수의 최댓값을 구하는 프로그램을 작성하시오. 
	 즉, 2n개의 스티커 중에서 점수의 합이 최대가 되면서 서로 변을 공유 하지 않는 스티커 집합을 구해야 한다.
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		
		while(count>0){
			
			int length = sc.nextInt();
			int score[][] = new int[2][length+1];
			int dp[][] = new int[2][length+1];
			
			for (int i=0;i<2;i++){
				for (int j=1;j<=length;j++){
					score[i][j]=sc.nextInt();
				}
			}
			
			dp[0][1]=score[0][1];
			dp[1][1]=score[1][1];
			
			for (int i=2;i<=length;i++){
				dp[0][i] = Math.max(dp[1][i-1],dp[1][i-2])+score[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2])+score[1][i];
			}
			
			System.out.println(Math.max(dp[0][length],dp[1][length]));
			
			count--;
		}
		
		sc.close();

	}

}
