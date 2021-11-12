package programmers_HighScoreKit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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

	public static int[] BestAlbum(String[] genres, int[] plays) {

		// 결과
		List<Integer> result = new ArrayList<>();

		// < 장르 , 전체 재생 횟수 >
		Map<String, Integer> count = new HashMap<>();

		// < 장르 , [고유번호, 재생횟수] >
		Map<String, List<int[]>> map = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			// count 추가
			count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);

			// map 추가
			List<int[]> target = map.getOrDefault(genres[i], new ArrayList<>());
			target.add(new int[] { i, plays[i] });
			map.put(genres[i], target);
		}

		// 장르만 뽑아서 재생 횟수 내림차순으로 정렬
		List<String> keys = new ArrayList<>(count.keySet());
		Collections.sort(keys, (a, b) -> count.get(b) - count.get(a));

		for (String key : keys) {

			List<int[]> target = map.get(key);

			// 재생순서 내림차순, 같다면 고유번호 오름차순
			Collections.sort(target, new Comparator<int[]>() {
				@Override
				public int compare(int[] a, int[] b) {
					return (a[1] == b[1]) ? a[0] - b[0] : b[1] - a[1];
				}
			});

			// 2개만 추가
			for (int i = 0; i < 2 && i < target.size(); i++) {
				result.add(target.get(i)[0]);
			}

		}

		return result.stream().mapToInt(i -> i).toArray();

	}

	public static void main(String[] args) {
		String[] s = { "classic", "pop", "classic", "classic", "pop" };
		int[] i = { 500, 600, 150, 800, 2500 };
		BestAlbum(s, i);
		return;
	}

}
