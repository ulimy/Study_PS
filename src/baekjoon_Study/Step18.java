package baekjoon_Study;

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

	public static void main(String[] args) {
		// p_10828();
		// p_10773();
		// p_9012();
		p_4949();

		return;
	}

}
