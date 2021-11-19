package programmers_HighScoreKit;

import java.util.Arrays;

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

	public static void main(String[] args) {
		kthNumber(new int[] { 1, 5, 2, 6, 3, 7, 4 }, new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } });

	}

}
