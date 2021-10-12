package baekjoon_Study;

import java.util.Scanner;

// 분할정복
public class Step20 {

	// 색종이 접기
	public static int[][] origami;
	public static int white = 0;
	public static int blue = 0;

	public static void cut(int row, int col, int size) {

		int color = origami[row][col];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (origami[i + row][j + col] != color) {
					size /= 2;
					cut(row, col, size); // 왼쪽 위
					cut(row, col + size, size); // 오른쪽 위
					cut(row + size, col, size);// 왼쪽 아래
					cut(row + size, col + size, size);// 오른쪽 아래
					return;
				}
			}
		}

		if (color == 0) {
			white++;
		} else {
			blue++;
		}

		return;
	}

	public static void p_2630() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		origami = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				origami[i][j] = sc.nextInt();
			}
		}

		sc.close();

		cut(0, 0, n);

		System.out.println(white);
		System.out.println(blue);

		return;
	}

	public static void main(String[] args) {
		p_2630();

		return;
	}

}
