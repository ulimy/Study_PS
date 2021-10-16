package baekjoon_Study;

import java.util.Arrays;
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

	public static long pow(long num, int exponent) {

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

	// 이항계수
	/*
	 * 이항계수 => 순서를 고려하지 않는 조합 ( nCk ) -> n! / ((n-k)! * k!)
	 * 
	 * 페르마의 소 정리 a^(p-1) = 1(mod p) -> a * a^(p-2) = 1(mod p) --> a의 역원 :
	 * a^(p-2) (mod p)
	 * 
	 * a*(b^-1)%p = ( a * b^(p-2) ) % p = ( ( a % p ) * ( b^(p-2) % p ) ) % p
	 * 
	 * a-> n! b-> (n-k)! * k!
	 * 
	 */

	// 팩토리얼
	public static long factorial(long num) {
		long result = 1;

		while (num > 1) {
			result = (result * num) % 1000000007;
			num--;
		}

		return result;

	}

	// 곱셈
	public static long pow_11401(long base, long exponent) {

		int p = 1000000007;

		// 지수가 1이라면 그 숫자 그대로
		if (exponent == 1) {
			return base % p;
		}

		long result = pow_11401(base, exponent / 2);

		// 지수가 홀수라면 한번 더 곱해주기
		if (exponent % 2 == 1) {
			return (result * result % p) * base % p;
		}

		return result * result % p;
	}

	public static void p_11401() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();

		int p = 1000000007;

		// 팩토리얼 구하기
		long a = factorial(n);
		long b = (factorial(n - k) * factorial(k)) % p;

		long result = (a % p) * (pow_11401(b, p - 2) % p) % p;

		System.out.println(result);

		return;
	}

	// 행렬 곱셈
	public static void p_2740() {
		Scanner sc = new Scanner(System.in);

		// 행렬 A
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		// 행렬 B
		sc.nextInt();
		int k = sc.nextInt();
		int[][] b = new int[m][k];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < k; j++) {
				b[i][j] = sc.nextInt();
			}
		}

		sc.close();

		// 곱셈
		int[][] result = new int[n][k];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {

				int sum = 0;
				for (int x = 0; x < m; x++) {
					sum += a[i][x] * b[x][j];
				}
				result[i][j] = sum;

			}
		}

		StringBuilder print = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String s = Arrays.toString(result[i]);
			print.append(s.substring(1, s.length() - 1).replace(",", "") + "\n");
		}

		System.out.println(print.toString());

		return;
	}

	// 행렬 제곱
	public static int n;

	public static int[][] matrix_pow(int[][] arr, long b) {

		// 지수가 1
		if (b == 1) {
			return arr;
		}

		int[][] temp = matrix_pow(arr, b / 2);

		// arr * arr
		int[][] result = matrix_multiply(temp, temp);

		// 지수가 홀수라면 한번 더 result*arr
		if (b % 2 == 1) {
			result = matrix_multiply(result, arr);
		}

		return result;

	}

	public static int[][] matrix_multiply(int[][] arr_1, int[][] arr_2) {

		int[][] result = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum = 0;
				for (int k = 0; k < n; k++) {
					sum = (sum + (arr_1[i][k] * arr_2[k][j]) % 1000) % 1000;
				}
				result[i][j] = sum;
			}
		}

		return result;
	}

	public static void p_10830() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		long b = sc.nextLong();

		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt() % 1000;
			}
		}

		int[][] result = matrix_pow(arr, b);

		StringBuilder print = new StringBuilder();

		for (int i = 0; i < n; i++) {
			String s = Arrays.toString(result[i]);
			print.append(s.substring(1, s.length() - 1).replace(",", "") + "\n");
		}

		System.out.println(print.toString());

		sc.close();

		return;
	}

	public static void main(String[] args) {
		// p_2630();
		// p_1992();
		// p_1780();
		// p_1629();
		// p_11401();
		// p_2740();
		p_10830();
		return;
	}

}
