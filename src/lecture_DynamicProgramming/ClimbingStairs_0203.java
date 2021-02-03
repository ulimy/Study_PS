package lecture_DynamicProgramming;

public class ClimbingStairs_0203 {
	
	// 계단 오르기
	
	public int solve(int n){
		// 0부터 시작하기위해 n+1만큼
		int[] dp = new int[n+1];
		
		// 1혹은 2이면 답은 정해져있음
		if(n==1) return 1;
		if(n==2) return 2;
		
		// 3 이상이면 여기로 넘어와서
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
