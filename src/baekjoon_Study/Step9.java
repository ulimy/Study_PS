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

	// 1929 소수구하기는 2581과 거의 동일하고 그또한 에라토스테네스의 체로 풀었으므로 생략

	// 베르트랑 공준
	public static void p_4948() {

		// 1~246912까지의 소수 구하기 (246912 -> 123456*2)
		boolean[] arr = new boolean[246913];

		arr[0] = true;
		arr[1] = true;

		// 에라토스테네스의 체 이용
		for (int i = 2; i * i <= 246912; i++) {
			if (!arr[i]) {
				int index = i * 2;
				while (index <= 246912) {
					arr[index] = true;
					index += i;
				}
			}
		}

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		StringBuilder result = new StringBuilder();

		while (num > 0) {
			int count = 0;

			// num보다 커야하므로 num+1부터 시작
			for (int i = num + 1; i <= num * 2; i++) {
				if (!arr[i])
					count++;
			}

			result.append(count + "\n");

			num = sc.nextInt();
		}

		sc.close();

		System.out.println(result.toString());

		return;
	}

	// 골드바흐의 추측
	public static void p_9020() {
		// 1~10000까지의 소수 구하기
		boolean[] arr = new boolean[10001];

		arr[0] = true;
		arr[1] = true;

		// 에라토스테네스의 체 이용
		for (int i = 2; i * i <= 10000; i++) {
			if (!arr[i]) {
				int index = i * 2;
				while (index <= 10000) {
					arr[index] = true;
					index += i;
				}
			}
		}

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < count; i++) {

			int num = sc.nextInt();

			// 어차피 덧셈으로 대응되므로 반만 해도 됨!
			// 차이가 가장 작은 값을 고르기 위해 선택
			int index = num / 2 + 1;

			while (true) {
				if (!arr[index] && !arr[num - index])
					break;
				index--;
			}

			result.append(Math.min(index, num - index) + " " + Math.max(index, num - index) + "\n");

		}

		sc.close();

		System.out.println(result.toString());

		return;

	}

	// 직사각형에서 탈출
	public static void p_1085() {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		sc.close();

		// 왼쪽 or 오른쪽
		int result = Math.min(x, w - x);

		// 아래 or 위
		result = Math.min(result, Math.min(h - y, y));

		System.out.println(result);

		return;

	}

	public static void main(String[] args) {
		// p_1978();
		// p_2581();
		// p_11653();
		// p_4948();
		// p_9020();
		p_1085();
		return;
	}

}
