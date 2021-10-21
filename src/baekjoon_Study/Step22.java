package baekjoon_Study;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// 우선순위 큐
public class Step22 {

	// 최대 힙
	public static void p_11279() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		// 최대값을 뽑아야하므로 내림차순
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < count; i++) {
			int target = sc.nextInt();

			if (target == 0) {
				if (pq.isEmpty()) {
					result.append("0\n");
				} else {
					result.append(pq.poll() + "\n");
				}
			} else {
				pq.offer(target);
			}
		}

		sc.close();

		System.out.println(result.toString());

		return;
	}

	// 최소 힙
	public static void p_1927() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		// 기본갑이 오름차순
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < count; i++) {
			int target = sc.nextInt();

			if (target == 0) {
				if (pq.isEmpty()) {
					result.append("0\n");
				} else {
					result.append(pq.poll() + "\n");
				}
			} else {
				pq.offer(target);
			}

		}

		sc.close();

		System.out.println(result.toString());

		return;
	}

	// 절댓값 힙
	public static void p_11286() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				if (Math.abs(a) == Math.abs(b)) { // 절댓값 같으면 오름차순
					return a - b;
				} else {
					return Math.abs(a) - Math.abs(b);
				}
			}

		});

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < count; i++) {
			int target = sc.nextInt();

			if (target == 0) {
				if (pq.isEmpty()) {
					result.append("0\n");
				} else {
					result.append(pq.poll() + "\n");
				}
			} else {
				pq.offer(target);
			}
		}

		sc.close();

		System.out.println(result.toString());

		return;
	}

	// 가운데를 말해요
	public static void p_1655() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		// 왼쪽 max
		PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
		// 오른쪽 min
		PriorityQueue<Integer> right = new PriorityQueue<>();

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < count; i++) {
			int target = sc.nextInt();

			// 크기가 같으면 왼쪽에 넣기
			if (right.size() == left.size()) {
				left.offer(target);
			}
			// 크기가 다르면 오른쪽에 넣기
			else {
				right.offer(target);
			}

			if (!right.isEmpty() && !left.isEmpty()) {
				// right의 최소값이 left의 최대값보다 작다면 swap
				if (right.peek() < left.peek()) {
					int temp = right.poll();
					right.offer(left.poll());
					left.offer(temp);
				}
			}

			result.append(left.peek() + "\n");

		}

		sc.close();

		System.out.println(result.toString());

		return;

	}

	public static void main(String[] args) {
		// p_11279();
		// p_1927();
		// p_11286();
		p_1655();

		return;
	}

}
