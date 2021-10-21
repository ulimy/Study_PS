package baekjoon_Study;

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

	public static void main(String[] args) {
		p_11279();

		return;
	}

}
