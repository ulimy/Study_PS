package programmers_HighScoreKit;

import java.util.Arrays;

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

	public static void main(String[] args) {

		return;
	}

}
