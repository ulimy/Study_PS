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

	// 쿼드 트리
	public static int[][] video;
	public static StringBuilder quad_tree;

	public static void quad(int row, int col, int size) {
		int compare = video[row][col];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (video[i + row][j + col] != compare) {
					size /= 2;
					quad_tree.append("(");
					quad(row, col, size); // 왼쪽 위
					quad(row, col + size, size); // 오른쪽 위
					quad(row + size, col, size);// 왼쪽 아래
					quad(row + size, col + size, size);// 오른쪽 아래
					quad_tree.append(")");
					return;
				}
			}
		}

		quad_tree.append(compare);

		return;
	}

	public static void p_1992() {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		video = new int[n][n];
		quad_tree = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();
			for (int j = n - 1; j >= 0; j--) {
				video[i][j] = input.charAt(j) - '0';
			}
		}

		sc.close();

		quad(0, 0, n);

		System.out.println(quad_tree.toString());

		return;
	}

	// 종이의 개수
	public static int[][] paper;
	public static int minus = 0;
	public static int zero = 0;
	public static int plus = 0;

	public static void cut_2(int row, int col, int size) {
		int compare = paper[row][col];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (paper[i + row][j + col] != compare) {
					size /= 3;

					cut_2(row, col, size); // (0,0)
					cut_2(row, col + size, size); // (0,1)
					cut_2(row, col + (size * 2), size); // (0,2)

					cut_2(row + size, col, size); // (1,0)
					cut_2(row + size, col + size, size); // (1,1)
					cut_2(row + size, col + (size * 2), size); // (1,2)

					cut_2(row + (size * 2), col, size); // (2,0)
					cut_2(row + (size * 2), col + size, size); // (2,1)
					cut_2(row + (size * 2), col + (size * 2), size); // (2,2)

					return;
				}
			}
		}

		switch (compare) {
		case -1:
			minus++;
			break;
		case 0:
			zero++;
			break;
		case 1:
			plus++;
			break;
		}

		return;
	}

	public static void p_1780() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		paper = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				paper[i][j] = sc.nextInt();
			}
		}

		sc.close();

		cut_2(0, 0, n);

		System.out.println(minus + "\n" + zero + "\n" + plus);

		return;
	}

	// 곱셈
	public static int a, b, c;

	public static long pow(int num, int exponent) {

		// 지수가 1이라면 그 숫자 그대로
		if (exponent == 1) {
			return num % c;
		}

		long result = pow(num, exponent / 2);

		// 지수가 홀수라면 한번 더 곱해주기
		if (exponent % 2 == 1) {
			return (result * result % c) * num % c;
		}

		return result * result % c;
	}

	public static void p_1629() {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		sc.close();

		System.out.println(pow(a, b));

		return;
	}

	public static void main(String[] args) {
		// p_2630();
		// p_1992();
		// p_1780();
		p_1629();
		return;
	}

}
