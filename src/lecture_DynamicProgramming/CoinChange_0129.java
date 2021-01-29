package lecture_DynamicProgramming;

import java.util.Arrays;

public class CoinChange_0129 {
	/* ���� ������ coin�� �̿��Ͽ� �ּ����� ������ �ʿ��� �ݾ� ����� */
	
	public int solve(int[] coins, int amount){
		// 1. amount+1�� max�� ����
		int max = amount +1;
		// 2. amount+1 ��ŭ dp�迭 �����Ͽ� max������ ����, 0��°�� 0����
		// dp[i] -> i���� �������� �ʿ��ߴ� ����
		int[] dp = new int[max];
		Arrays.fill(dp, max);
		dp[0]=0;
		
		for (int i=1;i<=amount;i++){
			for (int j=0;j<coins.length;j++){
				// coin������ ������ �� �ʿ䰡 ����
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
