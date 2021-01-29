package lecture_DynamicProgramming;

import java.util.Arrays;

public class CoinChange_0129 {
	/* 여러 종류의 coin을 이용하여 최소한의 개수로 필요한 금액 만들기 */
	
	public int solve(int[] coins, int amount){
		// 1. amount+1로 max값 세팅
		int max = amount +1;
		// 2. amount+1 만큼 dp배열 선언하여 max값으로 세팅, 0번째는 0으로
		// dp[i] -> i원을 만들기까지 필요했던 개수
		int[] dp = new int[max];
		Arrays.fill(dp, max);
		dp[0]=0;
		
		for (int i=1;i<=amount;i++){
			for (int j=0;j<coins.length;j++){
				// coin값보다 작으면 할 필요가 없음
				if(i>=coins[j]){
					dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
				}
			}
		}
		
		return dp[amount]>amount?-1:dp[amount];
	}

	public static void main(String[] args) {
		CoinChange_0129 a = new CoinChange_0129();
		int[] coins = {1,2,5};
		int amount = 11;
		
		System.out.println(a.solve(coins,amount));
		
	}

}
