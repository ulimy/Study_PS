package baekjoon_Study;

import java.util.Arrays;
import java.util.Scanner;

// 이분탐색
public class Step21 {

	// 수찾기
	public static void p_1920() {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int m = sc.nextInt();
		int[] targets = new int[m];
		for (int i = 0; i < m; i++) {
			targets[i] = sc.nextInt();
		}

		sc.close();

		Arrays.sort(arr);
		StringBuilder result = new StringBuilder();

		// 라이브러리 사용
		// for (int target : arr_m) {
		// int index = Arrays.binarySearch(arr_n, target);
		// result.append((index >= 0) ? 1 : 0);
		// result.append("\n");
		// }

		for (int target : targets) {
			int start = 0;
			int end = n - 1;
			int index = 0;

			while (start <= end) {
				int mid = (start + end) / 2;

				// 중간값이 더 큰 경우
				if (arr[mid] > target) {
					end = mid - 1;
				}

				// 중간 값이 더 작은 경우
				else if (arr[mid] < target) {
					start = mid + 1;
				}

				// 찾은 경우
				else {
					index = 1;
					break;
				}
			}

			result.append(index + "\n");
		}

		System.out.println(result.toString());

		return;
	}

	public static void main(String[] args) {
		p_1920();

		return;
	}

}
