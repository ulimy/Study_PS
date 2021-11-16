package programmers_HighScoreKit;

import java.util.PriorityQueue;

public class Heap {

	// 더 맵게
	public static int moreSpicy(int[] scoville, int K) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		int result = 0;

		for (int s : scoville) {
			minHeap.offer(s);
		}

		while (minHeap.peek() < K) {

			// 하나만 남았다면 더이상 연산 불가능
			if (minHeap.size() == 1) {
				return -1;
			}

			result++;
			minHeap.offer(minHeap.poll() + (minHeap.poll() * 2));
		}

		return result;
	}

	public static void main(String[] args) {

	}

}
