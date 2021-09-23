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

		Arrays.sort(meetings, new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b){
				return (a[1]==b[1])?a[0]-b[0]:a[1]-b[1];
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
	}

	public static void main(String[] args) {
		// p_11047();
		p_1931();
		return;
	}

}
