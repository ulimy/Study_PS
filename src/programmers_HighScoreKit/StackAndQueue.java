package programmers_HighScoreKit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StackAndQueue {

	// 기능 개발
	public static int[] DevelopFunction(int[] progresses, int[] speeds) {

		List<Integer> result = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < progresses.length; i++) {
			queue.offer(i);
		}

		while (!queue.isEmpty()) {

			int index = queue.poll();
			int count = 1;

			// 필요한 시간 계산
			int days = (int) Math.ceil((100 - progresses[index]) / speeds[index]);

			// 계산한 시간만큼 나머지 기능도 개발
			for (int i = index + 1; i < progresses.length; i++) {
				progresses[i] += (speeds[i] * days);
			}

			// 완료된 기능들 배포
			while (!queue.isEmpty() && progresses[queue.peek()] >= 100) {
				count++;
				queue.poll();
			}

			result.add(count);
		}

		return result.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		DevelopFunction(new int[] { 95, 90, 99, 99, 80, 99 }, new int[] { 1, 1, 1, 1, 1, 1 });
	}

}
