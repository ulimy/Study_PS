package programmers_HighScoreKit;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {

	// K번째 수
	public static int[] kthNumber(int[] array, int[][] commands) {
		int[] result = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
			Arrays.sort(temp);
			result[i] = temp[commands[i][2] - 1];
		}

		return result;
	}

	// 가장 큰 수
	public static String biggestNumber(int[] numbers) {
		StringBuilder result = new StringBuilder();

		// 비교를 위해 String으로 바꾸기
		String[] nums = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			nums[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(nums, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return (b + a).compareTo((a + b));
			}
		});

		// 배열에 0만 여러개 있는 경우
		if (nums[0].equals("0")) {
			return "0";
		}

		for (String num : nums) {
			result.append(num);
		}

		return result.toString();
	}

	// H-Index
	public static int h_index(int[] citations) {
		int result = 0;
		Arrays.sort(citations);

		for (int i = 0; i < citations.length; i++) {
			int h = citations[i];
			int k = citations.length - i; // h번 이상 인용된 논문

			if (k <= h) {
				result = k;
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		h_index(new int[] { 3, 0, 6, 1, 5 });

	}

}
