package programmers_HighScoreKit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class StackAndQueue {

	// 기능 개발
	public static int[] developFunction(int[] progresses, int[] speeds) {

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

	public static int printer(int[] priorities, int location) {

		// 프린터 대기 int[] {location, proterties}
		Queue<int[]> queue = new LinkedList<>();

		// 내림차순 중요도 저장
		PriorityQueue<Integer> importancy = new PriorityQueue<>((a, b) -> b - a);

		// 인쇄 정보 저장
		for (int i = 0; i < priorities.length; i++) {
			queue.offer(new int[] { i, priorities[i] });
			importancy.offer(priorities[i]);
		}

		int result = 0;

		while (!queue.isEmpty()) {
			int[] target = queue.poll();

			// 중요도 높다면 인쇄
			if (target[1] == importancy.peek()) {
				importancy.poll();
				result++;
				if (target[0] == location) { // 찾으면 바로 리턴
					return result;
				}
			} else { // 아니라면 맨 뒤로 보내기
				queue.offer(target);
			}
		}

		return result;
	}

	public static void main(String[] args) {

	}

}
