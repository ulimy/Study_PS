package programmers_HighScoreKit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BruteForce {

	// 모의고사
	static Queue<Integer> one = new LinkedList<>();
	static Queue<Integer> two = new LinkedList<>();
	static Queue<Integer> three = new LinkedList<>();
	static Map<Integer, Integer> score = new HashMap<>();

	public static int[] mockExam(int[] answers) {

		// queue 초기화
		init_queue();

		// 채점
		for (int answer : answers) {
			grading(answer);
		}

		List<Integer> result = new ArrayList<>();
		int max = -1;

		for (Integer key : score.keySet()) {
			Integer value = score.get(key);

			// 최대값과 똑같다면 추가
			if (value == max) {
				result.add(key);
			}

			// 더 크다면 result비우고 최대값 갱신
			else if (value > max) {
				result.clear();
				result.add(key);
				max = value;
			}
		}

		Collections.sort(result);

		return result.stream().mapToInt(i -> i).toArray();
	}

	// 큐 초기화
	public static void init_queue() {
		// 1,2번 초기화
		for (int i = 1; i <= 5; i++) {
			one.offer(i);

			if (i == 2)
				continue;
			two.offer(2);
			two.offer(i);
		}

		// 3번 초기화
		three.offer(3);
		three.offer(3);
		three.offer(1);
		three.offer(1);
		three.offer(2);
		three.offer(2);
		three.offer(4);
		three.offer(4);
		three.offer(5);
		three.offer(5);
		
		return;
	}

	// 점수 매기기
	public static void grading(int answer) {
		int o = one.poll();
		int t = two.poll();
		int th = three.poll();

		if (answer == o) {
			score.put(1, score.getOrDefault(1, 0) + 1);
		}

		if (answer == t) {
			score.put(2, score.getOrDefault(2, 0) + 1);
		}

		if (answer == th) {
			score.put(3, score.getOrDefault(3, 0) + 1);
		}

		one.offer(o);
		two.offer(t);
		three.offer(th);
		
		return;
	}

	public static void main(String[] args) {
		mockExam(new int[] { 1, 3, 2, 4, 2 });

	}

}
