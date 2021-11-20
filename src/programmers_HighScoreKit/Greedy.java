package programmers_HighScoreKit;

import java.util.Arrays;
import java.util.Stack;

public class Greedy {

	// 체육복
	public static int gymSuit(int n, int[] lost, int[] reserve) {

		// 전체 학생에게 체육복 한벌씩
		int[] students = new int[n + 1];
		Arrays.fill(students, 1);

		// 도난
		for (int l : lost) {
			students[l]--;
		}

		// 여벌
		for (int r : reserve) {
			students[r]++;
		}

		// 체육복 빌려주기
		for (int i = 1; i < students.length; i++) {
			if (students[i] == 0) {
				// 앞 번호
				if (i >= 2 && students[i - 1] >= 2) {
					students[i] = 1;
					students[i - 1]--;
					continue;
				}
				// 뒷 번호
				if (i < students.length - 1 && students[i + 1] >= 2) {
					students[i] = 1;
					students[i + 1]--;
					continue;
				}
			}
		}

		// 결과
		int result = 0;
		for (int i = 1; i < students.length; i++) {
			if (students[i] >= 1) {
				result++;
			}
		}

		return result;
	}

	// 조이스틱
	public static int joyStick(String name) {
		int answer = 0;
		int move = name.length() - 1; // 좌우이동하는 max값

		for (int i = 0; i < name.length(); i++) {
			// 상하 이동
			answer += Math.min('Z' - name.charAt(i) + 1, name.charAt(i) - 'A');

			// 다음글자가 A일 경우
			int next = i + 1;
			while (next < name.length() && name.charAt(next) == 'A') {
				next++;
			}
			// move : 그냥 일직선으로 가기
			// 0~i~0 : i+i
			// 뒤돌아서 i까지 가기 : name.length()-next
			move = Math.min(move, (i + i) + name.length() - next);
		}

		answer += move;

		return answer;

	}

	// 큰 수 만들기
	public static String makeBigNumber(String number, int k) {
		char[] result = new char[number.length() - k];
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < number.length(); i++) {

			// 뒤에 오는 값보다 작으면 빼기
			while (!stack.isEmpty() && stack.peek() < number.charAt(i) && k-- > 0) {
				stack.pop();
			}

			stack.push(number.charAt(i));
		}

		for (int i = 0; i < result.length; i++) {
			result[i] = stack.get(i);
		}

		return String.valueOf(result);
	}

	// 구명보트
	public static int lifeboat(int[] people, int limit) {
		int result = 0;

		Arrays.sort(people);
		int front = 0;
		int back = people.length - 1;

		// 무게 제일 작은 사람이 무게 제일 큰 사람과 함께 타야함
		while (front < back) {
			if (people[front] + people[back] <= limit) {
				result++;
				people[front++] = -1;
				people[back--] = -1;
			} else {
				back--;
			}
		}

		for (int p : people) {
			if (p > 0) {
				result++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		lifeboat(new int[] { 70, 50, 80 }, 100);
	}

}
