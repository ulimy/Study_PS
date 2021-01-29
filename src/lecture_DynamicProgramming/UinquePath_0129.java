package lecture_DynamicProgramming;

public class UinquePath_0129 {
	/*
	 * ���� ������ ������ �Ʒ��� ���ϱ� ���� ����� ���� ���ϱ� input: m=3(����) n=2(����) output : 3
	 */

	public int solve(int m, int n) {
		Integer[][] map = new Integer[n][m];

		// ���� ù°�� 1�� ä���
		for (int i=0;i<m;i++) {
			map[0][i] = 1;
		}

		// ���� ù���� 1�� ä���
		for (int i=0;i<n;i++) {
			map[i][0] = 1;
		}

		// ���ʰ� ������ ���ϸ� �װ��� ���� ���� ����� ���� ��!
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
