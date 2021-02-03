package lecture_DynamicProgramming;

public class ClimbingStairs_0203 {
	
	// ��� ������
	
	public int solve(int n){
		// 0���� �����ϱ����� n+1��ŭ
		int[] dp = new int[n+1];
		
		// 1Ȥ�� 2�̸� ���� ����������
		if(n==1) return 1;
		if(n==2) return 2;
		
		// 3 �̻��̸� ����� �Ѿ�ͼ�
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		
		for (int i=3;i<=n;i++){
			dp[i] = dp[i-1]+dp[i-2];
		}

		return dp[n];
	}

	public static void main(String[] args) {
		ClimbingStairs_0203 a = new ClimbingStairs_0203();
		System.out.println(a.solve(4));

	}

}
