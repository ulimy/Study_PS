package programmers_Level_2;

public class StringCompression {

	public static int solution(String s) {
		int answer = s.length();

		// 전체 길이/2까지만 압축 가능
		for (int i = 1; i <= s.length() / 2; i++) {
			answer = Math.min(answer, split(s, i));
		}

		return answer;
	}

	public static int split(String s, int unit) {
		int result = 0;
		String pre = ""; // 과거 문자열
		int duplicated = 1; // 중복된 문자열의 개수

		int index = 0;
		while (index + unit <= s.length()) {
			// 현재 문자열 구하고 index 증가
			String cur = s.substring(index, index + unit);
			index += unit;

			// 과거 문자열과 같은 경우 duplicated 1 증가
			if (cur.equals(pre)) {
				duplicated++;
				continue;
			}

			// 과거 문자열과 다른 경우

			// duplicated가 2 이상이라면 과거에 반복된 문자열이 존재함
			if (duplicated >= 2) {
				result += (int) (Math.log10(duplicated) + 1);
			}

			// 초기화
			pre = cur;
			duplicated = 1;

			// 길이 증가
			result += unit;
		}

		// duplicated가 2 이상이라면 마지막 문자열이 중복되었음
		if (duplicated >= 2) {
			result += (int) (Math.log10(duplicated) + 1);
		}

		// unit보다 작은 크기로 남은 마지막 조각 더해주기
		result += (s.length() - index);

		return result;
	}

	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
	}

}
