package baekjoon_Study;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// 스택
public class Step18 {

	// 스택
	public static void p_10828() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < count; i++) {
			String command = sc.next();
			switch (command) {

			case "push":
				stack.push(sc.nextInt());
				break;

			case "pop":
				result.append((stack.isEmpty() ? -1 : stack.pop()) + "\n");
				break;

			case "size":
				result.append(stack.size() + "\n");
				break;

			case "empty":
				result.append((stack.isEmpty() ? 1 : 0) + "\n");
				break;

			case "top":
				result.append((stack.isEmpty() ? -1 : stack.peek()) + "\n");
				break;
			}
		}

		sc.close();

		System.out.println(result.toString());

		return;
	}

	// 제로
	public static void p_10773() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		int result = 0;

		for (int i = 0; i < count; i++) {
			int num = sc.nextInt();

			if (num == 0) {
				stack.pop();
			} else {
				stack.push(num);
			}
		}

		sc.close();

		for (Integer i : stack) {
			result += i;
		}

		System.out.println(result);

		return;
	}

	// 괄호
	public static void p_9012() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < count; i++) {

			char[] input = sc.next().toCharArray();
			Stack<Character> stack = new Stack<>();
			boolean check = true;

			for (char c : input) {
				if (c == '(') {
					stack.push(c);
				} else {
					// 괄호를 닫아야 하는데 여는 기호가 없다면 올바르지 않음
					if (stack.isEmpty()) {
						check = false;
						break;
					}
					stack.pop();
				}
			}

			result.append(((stack.isEmpty() && check) ? "YES" : "NO") + "\n");

		}

		sc.close();

		System.out.println(result.toString());

		return;
	}

	// 균형잡힌 세상
	public static void p_4949() {
		Scanner sc = new Scanner(System.in);
		StringBuilder result = new StringBuilder();
		String input = sc.nextLine();

		while (!input.equals(".")) {

			input = input.replace(".", ""); // 마침표 지우기
			input = input.replaceAll("[a-zA-Z]", ""); // 알파벳 지우기
			input = input.replaceAll(" ", "");// 공백 지우기

			Stack<Character> stack = new Stack<>();
			boolean check = true;

			for (char c : input.toString().toCharArray()) {

				if (c == '(' || c == '[') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.isEmpty() || stack.peek() != '(') {
						check = false;
						break;
					} else {
						stack.pop();
					}
				} else {
					if (stack.isEmpty() || stack.peek() != '[') {
						check = false;
						break;
					} else {
						stack.pop();
					}
				}
			}

			result.append(((stack.isEmpty() && check) ? "yes" : "no") + "\n");

			input = sc.nextLine();
		}

		sc.close();

		System.out.println(result.toString());

		return;

	}

	// 스택 수열
	public static void p_1874() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		sc.close();

		int max = 0;
		StringBuilder result = new StringBuilder();

		for (int num : nums) {

			// num값이 스택에 있는 최대값보다 클 경우 num까지 push
			if (max < num) {
				for (int i = max + 1; i <= num; i++) {
					stack.push(i);
					result.append("+\n");
				}
				max = num;
			}

			if (stack.peek() != num) { // peek값이 num과 다르다면 수열 불가능
				System.out.println("NO");
				return;
			} else { // 해당 값이라면 pop
				stack.pop();
				result.append("-\n");
			}

		}

		System.out.println(result.toString());

		return;
	}

	// 오큰수
	public static void p_17298() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] nums = new int[count];
		int[] result = new int[count];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < count; i++) {
			nums[i] = sc.nextInt();
		}

		sc.close();

		Arrays.fill(result, -1); // result 초기화

		for (int i = 0; i < count; i++) {

			// 스택에 들어있는 인덱스를 통해 접근한값보다 현재값이 더 크다면 오큰수 발견
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				result[stack.pop()] = nums[i];
			}

			stack.push(i);

		}

		StringBuilder output = new StringBuilder();
		for (int r : result) {
			output.append(r + " ");
		}

		System.out.println(output.toString());

		return;
	}

	public static void main(String[] args) {
		// p_10828();
		// p_10773();
		// p_9012();
		// p_4949();
		// p_1874();
		p_17298();

		return;
	}

}
