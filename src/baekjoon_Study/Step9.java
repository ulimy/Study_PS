package baekjoon_Study;

import java.util.Scanner;

//기본수학 2
public class Step9 {

	// 소수 찾기
	public static void p_1978() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] nums = new int[count];
		int result = 0;

		for (int i = 0; i < count; i++) {
			nums[i] = sc.nextInt();
		}

		sc.close();

		for (int num : nums) {
			// 1은 소수가 아님
			if (num == 1)
				continue;

			boolean check = true;
			// Math.sqirt는 오차가 발생할 가능성이 있어서 사용X
			for (int i = 2; i * i <= num; i++) {
				if (num % i == 0) {
					check = false;
					break;
				}
			}

			if(check) result++;
		}

		System.out.println(result);

		return;

	}

	public static void main(String[] args) {
		p_1978();
		return;
	}

}
