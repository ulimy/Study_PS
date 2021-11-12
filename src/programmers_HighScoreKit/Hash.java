package programmers_HighScoreKit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hash {

	// 완주하지 못한 선수
	public String AthletesNotComplete(String[] participant, String[] completion) {

		Arrays.sort(participant);
		Arrays.sort(completion);

		for (int i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}

		return participant[participant.length - 1];
	}

	// 전화번호 목록
	public boolean PhoneNumberList(String[] phone_book) {

		// 오름차순으로 정렬
		Arrays.sort(phone_book);

		// 제일 마지막은 할 필요 없으므로 length-1까지
		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i + 1].startsWith(phone_book[i])) {
				return false;
			}
		}

		return true;
	}

	// 위장
	public static int Camouflage(String[][] clothes) {
		int result = 1;

		Map<String, Set<String>> map = new HashMap<>();

		for (String[] input : clothes) {
			Set<String> target = map.getOrDefault(input[1], new HashSet<String>());
			target.add(input[0]);
			map.put(input[1], target);
		}

		for (Set<String> target : map.values()) {
			result *= (target.size() + 1); // 쓰거나 안쓰거나 - n+1가지 경우
		}

		result--; // 전부 다 안쓰는 경우 제외

		return result;
	}

	public static void main(String[] args) {
		return;
	}

}
