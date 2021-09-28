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

	public static void main(String[] args) {
		p_10828();
		return;
	}

}
