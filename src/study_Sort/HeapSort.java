package study_Sort;

import java.util.Arrays;

public class HeapSort {

	public static int[] heap = { 1, 9, 8, 5, 4, 2, 3, 7, 6 };

	public static void main(String[] args) {

		// 힙 만들기
		for (int i = 1; i < heap.length; i++) {
			int n = i; // 현재 진행중인 노드
			do {
				int root = (n - 1) / 2; // 부모노드

				// 부모노드보다 크면 위로 이동
				if (heap[root] < heap[n]) {
					int temp = heap[root];
					heap[root] = heap[n];
					heap[n] = temp;
				}

				n = root; // 위로 이동하였으니 index도 변경

			} while (n != 0); // 최상위로 가기 전까지만 반복
		}

		// 크기를 줄여가며 힙 재구성
		for (int i = heap.length - 1; i >= 0; i--) {

			// 가장 큰 값을 맨 뒤로 보내기 -> 오름차순
			int temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;

			int root = 0;
			int n;

			// 힙 재구성
			do {
				n = 2 * root + 1; // root의 자식노드

				// 범위 안에 들어있는지 확인 후 더 큰 자식노드 선택
				if (n < i - 1 && heap[n] < heap[n + 1]) {
					n++;
				}

				// 부모노드보다 크면 위로 이동
				if (n < i - 1 && heap[root] < heap[n]) {
					temp = heap[root];
					heap[root] = heap[n];
					heap[n] = temp;
				}

				root = n;

			} while (n < i);
		}

		System.out.println(Arrays.toString(heap));
		return;

	}

}
