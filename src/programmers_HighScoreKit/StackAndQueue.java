package programmers_HighScoreKit;

import java.util.ArrayList;
import java.util.List;

public class StackAndQueue {

	// 기능 개발
	public static int[] DevelopFunction(int[] progresses, int[] speeds) {

		List<Integer> result = new ArrayList<>();

		// 남은 작업들 중에 우선순위가 제일 높은 인덱스
		int index = 0;

		while (index < progresses.length) {
			int count = 0; // 배포 기능 개수

			// 우선순위가 가장 높은 기능개발을 위해 필요한 시간 , 나누어 떨어지지 않는다면 하루 더 추가
			int days = (100 - progresses[index]) / speeds[index];
			days += ((100 - progresses[index]) % speeds[index] == 0) ? 0 : 1;

			// 기능 개발 실행
			for (int i = index; i < progresses.length; i++) {
				progresses[i] += speeds[i] * days;
			}

			// 100 이상이면 배포
			while (index < progresses.length && progresses[index] >= 100) {
				count++;
				index++;
			}

			result.add(count);
		}

		return result.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {

	}

}
