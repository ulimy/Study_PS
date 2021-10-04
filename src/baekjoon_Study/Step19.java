package baekjoon_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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

	public static void main(String[] args) throws IOException {
		p_18258();

		return;
	}

}
