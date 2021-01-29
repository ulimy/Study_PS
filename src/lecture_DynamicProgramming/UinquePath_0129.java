package lecture_DynamicProgramming;

public class UinquePath_0129 {
	/*
	 * 왼쪽 위에서 오른쪽 아래로 향하기 위한 경로의 개수 구하기 input: m=3(세로) n=2(가로) output : 3
	 */

	public int solve(int m, int n) {
		Integer[][] map = new Integer[n][m];

		// 세로 첫째줄 1로 채우기
		for (int i=0;i<m;i++) {
			map[0][i] = 1;
		}

		// 가로 첫쨰줄 1로 채우기
		for (int i=0;i<n;i++) {
			map[i][0] = 1;
		}

		// 왼쪽과 위쪽을 더하면 그곳을 가기 위한 경로의 수가 됨!
		for (int i=1;i<n;i++) {
			for (int j=1;j<m;j++){
				map[i][j] = map[i-1][j]+map[i][j-1];
			}
		}
		
		return map[n-1][m-1];
	}

	public static void main(String[] args) {
		UinquePath_0129 a = new UinquePath_0129();
		int m = 7, n = 3;
		System.out.println(a.solve(m, n));
	}

}
