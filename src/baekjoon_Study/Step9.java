package baekjoon_Study;

import java.util.Scanner;

//기본수학 2
public class Step9 {

	// 소수 찾기
	public static void p_1978() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] nums = new int[count];
		int result = 0;

		for (int i = 0; i < count; i++) {
			nums[i] = sc.nextInt();
		}

		sc.close();

		for (int num : nums) {
			// 1은 소수가 아님
			if (num == 1)
				continue;

			boolean check = true;
			// Math.sqirt는 오차가 발생할 가능성이 있어서 사용X
			for (int i = 2; i * i <= num; i++) {
				if (num % i == 0) {
					check = false;
					break;
				}
			}

			if (check)
				result++;
		}

		System.out.println(result);

		return;

	}

	// 소수
	public static void p_2581() {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.close();

		// 소수라면 false / 아니라면 true
		boolean[] arr = new boolean[n + 1]; // 초기값 false
		arr[0] = true;
		arr[1] = true;

		// 2~n까지 에라토스테네스의 체 이용
		for (int i = 2; i * i <= n; i++) {
			// 소수라면 소수의 배수들 합성수 처리 해주기
			if (!arr[i]) {
				int index = i * 2;
				while (index <= n) {
					arr[index] = true;
					index += i;
				}
			}
		}

		int sum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = m; i <= n; i++) {
			if (!arr[i]) {
				sum += i;
				if (min == Integer.MAX_VALUE)
					min = i;
			}
		}

		if (sum > 0) {
			System.out.println(sum + "\n" + min);
		} else {
			System.out.println("-1");
		}

		return;

	}

	// 소인수 분해
	public static void p_11653() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		if (n == 1)
			return;

		StringBuilder result = new StringBuilder();

		// 소수로 나누어 떨어지지 않을때까지 계속 나누기
		// 나누어 떨어지지 않는다면 ++을 통해 다음 소수로 이동
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				result.append(i + "\n");
				n /= i;
			}
		}

		System.out.println(result.toString());
		
		return;
		
	}
	
	

	public static void main(String[] args) {
		// p_1978();
		// p_2581();
		p_11653();
		return;
	}

}
