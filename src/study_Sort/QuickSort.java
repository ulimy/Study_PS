package study_Sort;

import java.util.Arrays;

public class QuickSort {

	public static int[] arr = { 1, 9, 8, 5, 4, 2, 3, 7, 6 };

	public static int quickSort(int left, int right) {

		// 가장 오른쪽에 있는 값 pivot으로 잡기
		int pivot = arr[right];
		// pivot보다 작은 값 왼쪽으로 몰아주기위한 index
		int i = left - 1;

		// 왼쪽부터 하나씩 pivot과 비교하기 -> right는 pivot이므로 right-1까지만!
		for (int j = left; j < right ; j++) {
			// pivot보다 작으면 swap
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// 반복문이 끝나면 i가 pivot보다 작은 값들의 개수가 됨! -> 그 다음이 pivot 위치
		i++;
		int temp = arr[right];
		arr[right] = arr[i];
		arr[i] = temp;

		// pivot의 위치 리턴
		return i;
	}

	public static void sort(int left, int right) {
		if (left < right) {
			int p = quickSort(left, right);

			sort(left, p - 1); // pivot 기준 왼쪽정렬
			sort(p + 1, right); // pivot 기준 오른쪽 정렬
		}
		return;
	}

	public static void main(String[] args) {
		sort(0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		return;
	}

}
