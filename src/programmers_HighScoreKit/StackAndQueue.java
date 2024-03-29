package programmers_HighScoreKit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

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

	// 프린터
	public static int printer(int[] priorities, int location) {

		// 프린터 대기 int[] {location, properties}
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

	// 다리를 지나는 트럭
	public static int crossBridge(int bridge_length, int weight, int[] truck_weights) {

		Queue<Integer> bridge = new LinkedList<>();

		int w = 0; // 현재 다리위에 있는 트럭들의 총 무게
		int result = 0;

		for (int tw : truck_weights) {

			while (true) {

				// 다리가 비어있는 경우
				if (bridge.isEmpty()) {
					result++;
					bridge.add(tw);
					w += tw;
					break;
				}

				// 다리 끝에 도착
				else if (bridge.size() == bridge_length) {
					w -= bridge.poll();
				}

				// 다리가 비어있지 않은 경우
				else {
					result++;
					// 올라설 수 있다면 올라서기
					if (w + tw <= weight) {
						bridge.add(tw);
						w += tw;
						break;
					}
					// 올라설 수 없다면 한칸 이동
					else {
						bridge.add(0);
					}
				}

			}
		}

		// 마지막 트럭 건너기
		result += bridge_length;

		return result;
	}

	// 주식 가격
	public int[] stockPrice(int[] prices) {

		Stack<Integer> stack = new Stack<>();
		int[] result = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {

			// 감소했다면 감소된 모든 인덱스 뽑기
			while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
				int index = stack.pop();
				result[index] = i - index;
			}

			stack.push(i);
		}

		// 스택에 값이 남아있다면 끝까지 가격이 떨어지지 않음
		while (!stack.isEmpty()) {
			int index = stack.pop();
			result[index] = prices.length - index;
		}

		return result;
	}

	public static void main(String[] args) {

	}

}
