package programmers_HighScoreKit;

import java.util.Arrays;

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

	public static void main(String[] args) {

	}

}
