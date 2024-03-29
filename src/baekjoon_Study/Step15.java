package baekjoon_Study;

import java.util.Arrays;
import java.util.Scanner;

// 동적계획법
public class Step15 {

	// 피보나치
	public static void p_1003() {

		int[] fibonacci_zero = new int[41];
		int[] fibonacci_one = new int[41];

		fibonacci_zero[0] = 1;
		fibonacci_zero[1] = 0;
		fibonacci_one[0] = 0;
		fibonacci_one[1] = 1;

		for (int n = 2; n <= 40; n++) {
			fibonacci_zero[n] = fibonacci_zero[n - 1] + fibonacci_zero[n - 2];
			fibonacci_one[n] = fibonacci_one[n - 1] + fibonacci_one[n - 2];
		}

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < count; i++) {
			int num = sc.nextInt();
			result.append(fibonacci_zero[num] + " " + fibonacci_one[num] + "\n");
		}

		sc.close();

		System.out.println(result.toString());
		return;
	}

	// 신나는 함수 실행
	static int[][][] exciting = new int[21][21][21];

	public static boolean checkRange(int a, int b, int c) {
		return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
	}

	public static int w(int a, int b, int c) {

		// a,b,c가 배열 크기보다 작고 이미 계산된 적 있다면 바로 리턴
		if (checkRange(a, b, c) && exciting[a][b][c] != 0)
			return exciting[a][b][c];

		// 조건 1
		if (a <= 0 || b <= 0 || c <= 0)
			return 1;

		// 조건 2
		if (a > 20 || b > 20 || c > 20) {
			exciting[20][20][20] = w(20, 20, 20);
			return exciting[20][20][20];
		}

		if (a < b && b < c) { // 조건 3
			exciting[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		} else { // 조건 4
			exciting[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
		}

		return exciting[a][b][c];

	}

	public static void p_9184() {
		Scanner sc = new Scanner(System.in);
		StringBuilder result = new StringBuilder();

		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a == -1 && b == -1 && c == -1)
				break;

			result.append("w(" + a + ", " + b + ", " + c + ") = ");
			result.append(w(a, b, c) + "\n");

		}

		sc.close();

		System.out.println(result.toString());
		return;
	}

	// 01타일
	public static void p_1904() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		// 배열 초기화
		long[] tiles = new long[n + 1];
		tiles[1] = 1;
		if (n >= 2)
			tiles[2] = 2;

		if (n >= 3) {
			for (int i = 3; i <= n; i++) {
				// n-1개에 1붙이기 + n-2개에 00 붙이기
				tiles[i] = (tiles[i - 1] + tiles[i - 2]) % 15746;
			}

		}

		System.out.println(tiles[n]);

		return;
	}

	// 파도반 수열
	public static void p_9461() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] input = new int[count];
		int max = 0;

		// 테스트케이스 담기
		for (int i = 0; i < count; i++) {
			input[i] = sc.nextInt();
			max = Math.max(max, input[i]);
		}

		sc.close();

		// dp 초기화
		long[] padovan = new long[max + 1];
		padovan[1] = 1;
		if (max >= 2)
			padovan[2] = 1;
		if (max >= 3)
			padovan[3] = 1;
		if (max >= 4)
			padovan[4] = 2;
		if (max >= 5)
			padovan[5] = 2;

		if (max >= 6) {
			for (int i = 6; i <= max; i++) {
				padovan[i] = padovan[i - 1] + padovan[i - 5];
			}
		}

		// 결과 출력
		StringBuilder result = new StringBuilder();
		for (int in : input) {
			result.append(padovan[in] + "\n");
		}
		System.out.println(result.toString());

		return;

	}

	// RGB 거리
	public static void p_1149() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[][] expense = new int[count][3];
		int[][] dp = new int[count][3];

		for (int i = 0; i < count; i++) {
			expense[i][0] = sc.nextInt();
			expense[i][1] = sc.nextInt();
			expense[i][2] = sc.nextInt();
		}

		sc.close();

		// dp 초기화
		dp[0][0] = expense[0][0];
		dp[0][1] = expense[0][1];
		dp[0][2] = expense[0][2];

		for (int i = 1; i < count; i++) {
			// 겹치지 않는 두가지 색 중 더 작은 값 + 칠할 색
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + expense[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + expense[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + expense[i][2];
		}

		count--;
		System.out.println(Math.min(dp[count][0], Math.min(dp[count][1], dp[count][2])));

		return;
	}

	// 정수 삼각형
	public static void p_1932() {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[][] arr = new int[size][];
		int[][] dp = new int[size][];

		// 입력 받기
		for (int i = 0; i < size; i++) {
			arr[i] = new int[i + 1];
			dp[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();

		// dp 초기값
		dp[0][0] = arr[0][0];

		for (int i = 1; i < size; i++) {

			// 맨 앞
			dp[i][0] = dp[i - 1][0] + arr[i][0]; // 대각선 오른쪽 위 선택

			// 중간
			for (int j = 1; j < i; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
			}

			// 맨뒤
			dp[i][i] = dp[i - 1][i - 1] + arr[i][i]; // 대각선 왼쪽 위 선택
		}

		// 최대값 찾기
		int result = -1;
		for (int k = 0; k < size; k++) {
			result = Math.max(dp[size - 1][k], result);
		}

		System.out.println(result);

		return;
	}

	// 계단오르기
	public static void p_2579() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		long arr[] = new long[count];
		long dp[] = new long[count];

		for (int i = 0; i < count; i++) {
			arr[i] = sc.nextLong();
		}

		sc.close();

		// dp초기화
		if (count > 0)
			dp[0] = arr[0];
		if (count > 1)
			dp[1] = dp[0] + arr[1];
		if (count > 2)
			dp[2] = Math.max(arr[0], arr[1]) + arr[2];

		if (count > 3) {
			for (int i = 3; i < count; i++) {
				// i-3번째 계단과 i-1계단을 밟음 or i-2번째 계단 밝음
				dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
			}
		}

		System.out.println(dp[count - 1]);

		return;
	}

	// 1로 만들기
	public static void p_1463() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		// dp 초기화
		int[] dp = new int[N + 1];
		dp[0] = 0;
		dp[1] = 0;

		for (int i = 2; i <= N; i++) {
			// 1 빼기
			dp[i] = dp[i - 1] + 1;

			// 3으로 나누기
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}

			// 2로 나누기
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
		}

		System.out.println(dp[N]);

		return;

	}

	// 쉬운 계단수
	public static void p_10844() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		// 행 - 자릿수 열 - 선택된 숫자
		long[][] dp = new long[N][10];
		Arrays.fill(dp[0], 1);
		dp[0][0] = 0; // 0으로 시작하면 계단수 아님

		long mod = 1000000000;

		for (int i = 1; i < N; i++) {

			// 0 선택 -> 이전에 1선택됨
			dp[i][0] = dp[i - 1][1];

			// 9선택 -> 이전에 8선택됨
			dp[i][9] = dp[i - 1][8];

			// 1~8 --이거나 ++이거나
			for (int j = 1; j <= 8; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
			}
		}

		long result = 0;
		for (long num : dp[N - 1]) {
			result += num;
			result %= mod;
		}

		System.out.println(result);
		return;
	}

	// 포도주시식
	public static void p_2156() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] wines = new int[count];

		for (int i = 0; i < count; i++) {
			wines[i] = sc.nextInt();
		}

		sc.close();

		int[] dp = new int[count];
		dp[0] = wines[0];
		if (count > 1)
			dp[1] = dp[0] + wines[1];
		if (count > 2)
			dp[2] = Math.max(dp[1], Math.max(wines[0], wines[1]) + wines[2]);

		if (count > 3) {
			for (int i = 3; i < count; i++) {
				// i-3,i-1고르거나 i-2 고르기 or 아예 고르지않고 i-1선택
				dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + wines[i - 1], dp[i - 2]) + wines[i]);
			}
		}

		System.out.println(dp[count - 1]);
		return;

	}

	// 가장 긴 증가하는 부분수열
	public static void p_11053() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] nums = new int[count];

		for (int i = 0; i < count; i++) {
			nums[i] = sc.nextInt();
		}

		sc.close();

		int[] dp = new int[count];
		Arrays.fill(dp, 1);

		for (int j = 1; j < count; j++) {
			for (int k = 0; k < j; k++) {
				// 증가하는 제일 긴 값으로 설정
				if (nums[j] > nums[k]) {
					dp[j] = Math.max(dp[j], dp[k] + 1);
				}
			}
		}

		int result = -1;
		for (int num : dp) {
			result = Math.max(num, result);
		}

		System.out.println(result);
		return;

	}

	// 가장 긴 증가하는 부분수열
	public static void p_11054() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] nums = new int[count];

		for (int i = 0; i < count; i++) {
			nums[i] = sc.nextInt();
		}

		sc.close();

		int[] dp_up = new int[count];
		int[] dp_down = new int[count];
		Arrays.fill(dp_up, 1);
		Arrays.fill(dp_down, 1);

		// 0~i까지 증가하는 가장 긴 값 구하기
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp_up[i] = Math.max(dp_up[i], dp_up[j] + 1);
				}
			}
		}

		// i~count까지 감소하는 가장 긴 값 구하기
		for (int i = count - 1; i >= 0; i--) {
			for (int j = count - 1; j > i; j--) {
				if (nums[i] > nums[j]) {
					dp_down[i] = Math.max(dp_down[i], dp_down[j] + 1);
				}
			}
		}

		// dp_up + dp_down -> i를 기준으로 제일 긴 수열
		int result = 0;
		for (int k = 0; k < count; k++) {
			result = Math.max(result, dp_up[k] + dp_down[k]);
		}

		// 자기자신이 중복됨! 1빼기
		System.out.println(result - 1);
		return;
	}

	// 전깃줄
	public static void p_2565() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[][] electric = new int[count][2];

		for (int i = 0; i < count; i++) {
			electric[i][0] = sc.nextInt();
			electric[i][1] = sc.nextInt();
		}

		sc.close();

		// 살릴 수 있는 전깃줄의 개수
		int[] dp = new int[count];
		Arrays.fill(dp, 1);

		Arrays.sort(electric, (a, b) -> (a[0] - b[0]));

		for (int i = 0; i < count; i++) {
			// i 이전의 전깃줄 확인 -> 교차되지 않는다면 j까지에서 1 추가!
			for (int j = 0; j < i; j++) {
				if (electric[i][1] > electric[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int result = 0;
		for (int num : dp) {
			result = Math.max(num, result);
		}

		// 철거 개수 = 전체 - 살린 전깃줄 개수
		System.out.println(count - result);
		return;

	}

	// 최장 공통 부분 수열
	public static void p_9251() {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		sc.close();

		int[][] lcs = new int[a.length() + 1][b.length() + 1];

		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) { // 값이 같으면 이전보다 1추가
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else { // 값이 다르면 이전 두개의 값중에 더 큰 값
					lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
				}
			}
		}

		System.out.println(lcs[a.length()][b.length()]);
		return;
	}

	// 연속합
	public static void p_1912() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] nums = new int[count];

		for (int i = 0; i < count; i++) {
			nums[i] = sc.nextInt();
		}

		sc.close();

		int[] dp = new int[count];
		dp[0] = nums[0];
		int result = dp[0];

		for (int i = 1; i < count; i++) {
			// i-1번째까지의 최대 연속값+자기자신 or 그냥 자기자신
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			result = Math.max(result, dp[i]);
		}

		System.out.println(result);
		return;
	}

	// 평범한 배낭
	public static void p_12865(){
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		int max_weight = sc.nextInt();
		int[] weight = new int[count+1];
		int[] value = new int[count+1];
		
		for(int i=1;i<=count;i++){
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}
		
		sc.close();
		
		// i개의 아이템의 무게 j 
		int[][] dp = new int[count+1][max_weight+1];
		
		for(int j=1;j<=count;j++){
			for(int k=1;k<=max_weight;k++){
				
				// 일단 이전 값 저장
				dp[j][k] = dp[j-1][k];
				
				// k무게에서 내가 가진 무게를 빼도 0 이상이라면 선택 가능
				if(k-weight[j]>=0){
					// 이전 무게 or 남은 무게
					dp[j][k] = Math.max(dp[j-1][k], dp[j-1][k-weight[j]]+value[j]);
				}
			}
		}
		
		System.out.println(dp[count][max_weight]);
		
		return;
	}
	
	public static void main(String[] args) {
		// p_1003();
		// p_9184();
		// p_1904();
		// p_9461();
		// p_1149();
		// p_1932();
		// p_2579();
		// p_1463();
		// p_10844();
		// p_2156();
		// p_11053();
		// p_11053();
		// p_11054();
		// p_2565();
		// p_9251();
		// p_1912();
		p_12865();
		return;
	}

}
