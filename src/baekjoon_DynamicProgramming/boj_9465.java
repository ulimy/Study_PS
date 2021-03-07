package baekjoon_DynamicProgramming;

import java.util.Scanner;

public class boj_9465 {

	/*
	 ������� ������ ����̴� ���汸���� ��ƼĿ 2n���� �����ߴ�. ��ƼĿ�� 2�� n���� ��ġ�Ǿ� �ִ�. 
	 ����̴� ��ƼĿ�� �̿��� å���� �ٹ̷��� �Ѵ�.

	����̰� ������ ��ƼĿ�� ǰ���� �ſ� ���� �ʴ�. ��ƼĿ �� ���� ����, �� ��ƼĿ�� ���� �����ϴ� ��ƼĿ�� ��� �������� ����� �� ���� �ȴ�. 
	��, �� ��ƼĿ�� ����, ������, ��, �Ʒ��� �ִ� ��ƼĿ�� ����� �� ���� �ȴ�.
	 ��� ��ƼĿ�� ���� �� ���Ե� ����̴� �� ��ƼĿ�� ������ �ű��, ������ ���� �ִ밡 �ǰ� ��ƼĿ�� ������� �Ѵ�. ����, �� ��ƼĿ�� ������ �Ű��. 
	 ����̰� �� �� �ִ� ��ƼĿ�� ������ �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. 
	 ��, 2n���� ��ƼĿ �߿��� ������ ���� �ִ밡 �Ǹ鼭 ���� ���� ���� ���� �ʴ� ��ƼĿ ������ ���ؾ� �Ѵ�.
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
