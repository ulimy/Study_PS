package programmers_Level_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GroupPhoto {

	static String[] conditions; // 조건
	static Map<Character, Integer> friends; // 각 프렌즈의 pk
	static int[] location; // 정렬 후보 location[pk] -> 위치
	static boolean[] visited;
	static int answer;

	public static int solution(int n, String[] data) {
		// 초기화
		conditions = data;
		init();

		// 전체 경우의 수 찾아서 조건 확인
		findAllCases(0);

		return answer;
	}

	// friends 초기화
	public static void init() {
		answer = 0;

		location = new int[8];
		visited = new boolean[8];
		Arrays.fill(visited, false);

		friends = new HashMap<>();
		friends.put('A', 0);
		friends.put('C', 1);
		friends.put('F', 2);
		friends.put('J', 3);
		friends.put('M', 4);
		friends.put('N', 5);
		friends.put('R', 6);
		friends.put('T', 7);
	}

	public static void findAllCases(int count) {

		// 종료조건
		if (count == 8) {
			// 조건 성립한다면 answer 증가
			if (isValid()) {
				answer++;
			}
			return;
		}

		for (int i = 0; i < 8; i++) {
			// 방문한적 있다면 그냥 넘어가기
			if (visited[i]) {
				continue;
			}

			// 방문한적 없다면 방문처리하고 다음 반복
			visited[i] = true;
			location[i] = count;
			findAllCases(count + 1);

			// 반복 끝났으니 방문처리 취소
			visited[i] = false;
		}

	}

	public static boolean isValid() {
		for (String condition : conditions) {

			int f1 = location[friends.get(condition.charAt(0))]; // 제시자의 위치
			int f2 = location[friends.get(condition.charAt(2))]; // 상대방의 위치

			int dist = Math.abs(f1 - f2) - 1; // 제시자와 상대방 사이의 거리
			char sign = condition.charAt(3); // 조건에 제시된 부등호
			int num = condition.charAt(4) - '0'; // 조건에 제시된 숫자

			if (sign == '=' && dist != num) {
				return false;
			}

			else if (sign == '<' && dist >= num) {
				return false;
			}

			else if (sign == '>' && dist <= num) {
				return false;
			}

		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(solution(2, new String[] { "N~F=0", "R~T>2" }));
	}

}
