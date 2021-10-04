package baekjoon_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

// 큐, 덱
public class Step19 {

	// 큐 2
	public static void p_18258() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder result = new StringBuilder();
		int count = Integer.parseInt(br.readLine());
		LinkedList<Integer> queue = new LinkedList<>();

		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			switch (st.nextToken()) {
			case "push":
				// add는 삽입에 실패하면 오류를 발생시키므로 offer 이용
				queue.offer(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				result.append(((queue.isEmpty()) ? -1 : queue.poll()) + "\n");
				break;
			case "size":
				result.append(queue.size() + "\n");
				break;
			case "empty":
				result.append(((queue.isEmpty()) ? 1 : 0) + "\n");
				break;
			case "front":
				result.append(((queue.isEmpty()) ? -1 : queue.peek()) + "\n");
				break;
			case "back":
				result.append(((queue.isEmpty()) ? -1 : queue.peekLast()) + "\n");
				break;
			}

		}

		System.out.println(result.toString());

		return;
	}

	// 카드2
	public static void p_2164() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}

		while (queue.size() != 1) {
			queue.poll();
			queue.offer(queue.poll());

		}

		System.out.println(queue.poll());

		return;
	}

	// 요세푸스 문제
	public static void p_11866() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();

		Queue<Integer> queue = new LinkedList<>();
		StringBuilder result = new StringBuilder();
		result.append("<");

		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}

		while (!queue.isEmpty()) {

			// k-1명의 사람 뒤로 보내기
			for (int i = 0; i < k - 1; i++) {
				queue.offer(queue.poll());
			}

			// 제거
			result.append(queue.poll() + ", ");
		}

		result.delete(result.length() - 2, result.length());
		result.append(">");

		System.out.println(result.toString());

		return;
	}

	// public static void main(String[] args) throws IOException {
	public static void main(String[] args) {
		// p_18258();
		// p_2164();
		p_11866();

		return;
	}

}
