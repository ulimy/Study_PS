package baekjoon_Study;

import java.util.Scanner;

// 동적계획법
public class Step15 {

	// 피보나치
	public static void p_1003() {

		int[] fibonacci_zero = new int[41];
		int[] fibonacci_one = new int[41];

		fibonacci_zero[0] = 1;
		fibonacci_zero[1] = 0;
		fibonacci_one[0] = 0;
		fibonacci_one[1] = 1;

		for (int n = 2; n <= 40; n++) {
			fibonacci_zero[n] = fibonacci_zero[n - 1] + fibonacci_zero[n - 2];
			fibonacci_one[n] = fibonacci_one[n - 1] + fibonacci_one[n - 2];
		}

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < count; i++) {
			int num = sc.nextInt();
			result.append(fibonacci_zero[num] + " " + fibonacci_one[num] + "\n");
		}

		sc.close();

		System.out.println(result.toString());
		return;
	}

	// 신나는 함수 실행
	static int[][][] exciting = new int[21][21][21];

	public static boolean checkRange(int a, int b, int c) {
		return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
	}

	public static int w(int a, int b, int c) {

		// a,b,c가 배열 크기보다 작고 이미 계산된 적 있다면 바로 리턴
		if (checkRange(a, b, c) && exciting[a][b][c] != 0)
			return exciting[a][b][c];

		// 조건 1
		if (a <= 0 || b <= 0 || c <= 0)
			return 1;

		// 조건 2
		if (a > 20 || b > 20 || c > 20) {
			exciting[20][20][20] = w(20, 20, 20);
			return exciting[20][20][20];
		}

		if (a < b && b < c) { // 조건 3
			exciting[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		} else { // 조건 4
			exciting[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
		}

		return exciting[a][b][c];

	}

	public static void p_9184() {
		Scanner sc = new Scanner(System.in);
		StringBuilder result = new StringBuilder();

		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a == -1 && b == -1 && c == -1)
				break;

			result.append("w(" + a + ", " + b + ", " + c + ") = ");
			result.append(w(a, b, c) + "\n");

		}

		sc.close();

		System.out.println(result.toString());
		return;
	}

	// 01타일
	public static void p_1904() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		// 배열 초기화
		long[] tiles = new long[n + 1];
		tiles[1] = 1;
		if (n >= 2)
			tiles[2] = 2;

		if (n >= 3) {
			for (int i = 3; i <= n; i++) {
				// n-1개에 1붙이기 + n-2개에 00 붙이기
				tiles[i] = (tiles[i - 1] + tiles[i - 2]) % 15746;
			}

		}

		System.out.println(tiles[n]);

		return;
	}

	// 파도반 수열
	public static void p_9461() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] input = new int[count];
		int max = 0;

		// 테스트케이스 담기
		for (int i = 0; i < count; i++) {
			input[i] = sc.nextInt();
			max = Math.max(max, input[i]);
		}

		sc.close();

		// dp 초기화
		long[] padovan = new long[max + 1];
		padovan[1] = 1;
		if (max >= 2)
			padovan[2] = 1;
		if (max >= 3)
			padovan[3] = 1;
		if (max >= 4)
			padovan[4] = 2;
		if (max >= 5)
			padovan[5] = 2;

		if (max >= 6) {
			for (int i = 6; i <= max; i++) {
				padovan[i] = padovan[i - 1] + padovan[i - 5];
			}
		}

		// 결과 출력
		StringBuilder result = new StringBuilder();
		for (int in : input) {
			result.append(padovan[in] + "\n");
		}
		System.out.println(result.toString());

		return;

	}

	// RGB 거리
	public static void p_1149() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[][] expense = new int[count][3];
		int[][] dp = new int[count][3];

		for (int i = 0; i < count; i++) {
			expense[i][0] = sc.nextInt();
			expense[i][1] = sc.nextInt();
			expense[i][2] = sc.nextInt();
		}

		sc.close();

		// dp 초기화
		dp[0][0] = expense[0][0];
		dp[0][1] = expense[0][1];
		dp[0][2] = expense[0][2];

		for (int i = 1; i < count; i++) {
			// 겹치지 않는 두가지 색 중 더 작은 값 + 칠할 색
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + expense[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + expense[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + expense[i][2];
		}

		count--;
		System.out.println(Math.min(dp[count][0], Math.min(dp[count][1], dp[count][2])));

		return;
	}

	public static void main(String[] args) {
		// p_1003();
		// p_9184();
		// p_1904();
		// p_9461();
		p_1149();

		return;
	}

}
