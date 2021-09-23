package baekjoon_Study;

import java.util.Scanner;

public class Step16 {

	// 동전 0
	public static void p_11047() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int price = sc.nextInt();

		int[] coins = new int[count];

		for (int i = 0; i < count; i++) {
			coins[i] = sc.nextInt();
		}

		sc.close();

		int result = 0;

		for (int i = count - 1; i >= 0; i--) {
			if (coins[i] <= price) { // 동전값이 구하려는 값보다 작을 때만 실행
				result += price / coins[i];
				price %= coins[i];
			}
		}

		System.out.println(result);

		return;

	}

	public static void main(String[] args) {
		p_11047();
		return;
	}

}
