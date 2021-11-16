package programmers_HighScoreKit;

import java.util.Arrays;
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

	// 디스크 컨트롤러
	public static int diskController(int[][] jobs) {

		// 요청시간 오름차순 정렬
		Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

		// 현재 시간으로부터 시작 가능한 작업들을 소요시간 오름차순으로 정렬
		// int[] { 요청시간, 소요시간 }
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

		int index = 0; // pq에 들어갈 jobs index
		int cur = 0; // 현재 시간
		int count = 0; // 완료된 작업의 개수
		int result = 0; // 결과

		while (count < jobs.length) {

			// 시작 가능한 작업 전부 큐에 넣기
			while (index < jobs.length && jobs[index][0] <= cur) {
				pq.offer(jobs[index]);
				index++;
			}

			// 큐가 비어있다면 이전 작업 완료시점과 새로운 작업 요청 시점에 차이 발생
			if (pq.isEmpty()) {
				cur = jobs[index][0];
			}
			// 아니라면 시작 가능한 작업 존재하므로 작업하기
			else {
				int[] job = pq.poll();
				cur += job[1];
				result += (cur - job[0]);
				count++;
			}
		}

		return result / jobs.length;
	}

	public static int[] dualPriorityQueue(String[] operations) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

		for (String o : operations) {

			int num = Integer.parseInt(o.substring(2));

			// 삽입
			if (o.charAt(0) == 'I') {
				minHeap.offer(num);
				maxHeap.offer(num);
			} else {

				// 빈 큐 확인
				if (minHeap.isEmpty()) {
					continue;
				}

				// 최댓값 삭제
				if (num == 1) {
					int target = maxHeap.poll();
					minHeap.remove(target);
				}
				// 최솟값 삭제
				else {
					int target = minHeap.poll();
					maxHeap.remove(target);
				}
			}
		}

		return (minHeap.isEmpty()) ? new int[] { 0, 0 } : new int[] { maxHeap.poll(), minHeap.poll() };

	}

	public static void main(String[] args) {
		dualPriorityQueue(new String[] { "I 16", "D 1" });
	}

}
