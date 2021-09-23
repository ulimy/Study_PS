package baekjoon_Study;

import java.util.Arrays;
import java.util.Comparator;
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

	// 회의실 배정
	public static void p_1931() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[][] meetings = new int[count][2];

		for (int i = 0; i < count; i++) {
			meetings[i][0] = sc.nextInt();
			meetings[i][1] = sc.nextInt();
		}

		sc.close();

		Arrays.sort(meetings, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1];
			}
		});

		int pre_end = 0;
		int result = 0;

		for (int i = 0; i < count; i++) {
			if (pre_end <= meetings[i][0]) {
				pre_end = meetings[i][1];
				result++;
			}
		}

		System.out.println(result);

		return;
	}

	// ATM
	public static void p_11399() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] times = new int[count];

		for (int i = 0; i < count; i++) {
			times[i] = sc.nextInt();
		}

		sc.close();

		Arrays.sort(times);

		int result = 0;
		int pre = 0; // 직전 사람의 소요시간
		for (int t : times) {
			result += t;
			result += pre;
			pre += t;
		}

		System.out.println(result);

		return;
	}

	// 잃어버린 괄호
	public static void p_1541() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();

		// - 기준으로 나누기
		String[] arr = input.split("-");

		int result = 0;

		// 처음 - 전까지는 모두 더하기
		for (String s : arr[0].split("\\+")) {
			result += Integer.parseInt(s);
		}

		// 2번째부터는 가장 큰 값을 뺴야하므로 +를 기준으로 다 빼기
		for (int i = 1; i < arr.length; i++) {
			for (String s : arr[i].split("\\+")) {
				result -= Integer.parseInt(s);
			}
		}

		System.out.println(result);

		return;
	}

	// 주유소
	public static void p_13305() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		long[] dist = new long[count - 1]; // 거리
		long[] cost = new long[count]; // 기름값

		for (int i = 0; i < count - 1; i++) {
			dist[i] = sc.nextLong();
		}

		for (int i = 0; i < count; i++) {
			cost[i] = sc.nextLong();
		}

		sc.close();

		long result = 0;
		long min_cost = cost[0]; // 제일 작은 cost

		for (int i = 0; i < count - 1; i++) {

			// 더 작은 cost가 나타나면 갱신
			min_cost = Math.min(min_cost, cost[i]);

			// 제일 작은 cost로 기름값 구하기
			result += (min_cost * dist[i]);
		}

		System.out.println(result);

		return;

	}

	public static void main(String[] args) {
		// p_11047();
		// p_1931();
		// p_11399();
		// p_1541();
		p_13305();
		return;
	}

}
