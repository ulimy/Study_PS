package programmers_Level_2;

public class Country_124 {

	public static String solution(int n) {
		StringBuilder result = new StringBuilder();

		int[] arr = { 4, 1, 2 };

		while (n > 0) {
			result.insert(0, arr[n % 3]);
			n = (n - 1) / 3;
		}

		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution(4));
	}

}
