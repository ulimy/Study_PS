package lecture_QueueAndStack;

import java.util.Stack;

public class BaseballGame_0123 {

	/*
	 * C: 삭제 D: 앞의 값 *2 +: 앞의 두 값을 더한 값 만큼 더하기
	 */

	public int solve(String[] strs) {
		Stack<Integer> stack = new Stack<>();

		for (String op : strs) {
			switch (op) {
			case "C":
				stack.pop();
				break;
			case "D":
				stack.push(stack.peek() * 2);
				break;
			case "+":
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b);
				stack.push(a);
				stack.push(a + b);
				break;
			default:
				stack.push(Integer.valueOf(op));
			}
		}
		
		int sum=0;
		while(!stack.isEmpty()){
			sum+=stack.pop();
		}
		
		return sum;
	}

	public static void main(String[] args) {
		BaseballGame_0123 a = new BaseballGame_0123();

		String[] strs = { "5", "-2", "4", "C", "D", "9", "+", "+" };
		System.out.println(a.solve(strs));
	}

}
