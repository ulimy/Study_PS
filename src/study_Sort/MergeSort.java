package study_Sort;

import java.util.Arrays;

public class MergeSort {

	public static int[] arr = { 1, 9, 8, 5, 4, 2, 3, 7, 6 };
	public static int[] sorted = new int[arr.length];

	public static void mergeSort(int start, int end) {

		if (start < end) {

			// 반으로 나눠서 재귀호출
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);

			int i = start; // 반으로 나눈 왼쪽
			int j = mid + 1; // 반으로 나눈 오른쪽
			int index = i; // 정렬된 값을 집어 넣을 곳

			while (i <= mid && j <= end) {
				// 더 작은 값 넣어주기
				if (arr[i] <= arr[j]) {
					sorted[index] = arr[i];
					i++;
				} else {
					sorted[index] = arr[j];
					j++;
				}
				index++;
			}

			// 남은 데이터 마저 넣어주기
			if (i > mid) { // 왼쪽이 먼저 끝났으므로 남은 오른쪽 배열 넣어주기
				for (int k = j; k <= end; k++) {
					sorted[index++] = arr[k];
				}
			} else { // 오른쪽이 먼저 끝났으므로 남은 왼쪽 배열 넣어주기
				for (int k = i; k <= mid; k++) {
					sorted[index++] = arr[k];
				}
			}

			// 정렬 완료된 결과 arr에 다시 넣어주기
			for (int t = start; t <= end; t++) {
				arr[t] = sorted[t];
			}
		}
	}

	public static void main(String[] args) {
		mergeSort(0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

}
