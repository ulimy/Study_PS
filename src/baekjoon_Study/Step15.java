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
	}

	public static void main(String[] args) {
		p_1003();
	}

}
