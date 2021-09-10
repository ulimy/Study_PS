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

			result.append("w("+a+", "+b+", "+c+") = ");
			result.append(w(a, b, c) + "\n");

		}

		sc.close();

		System.out.println(result.toString());
		return;
	}

	public static void main(String[] args) {
		// p_1003();
		p_9184();
		
		return;
	}

}
