package baekjoon_Study;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// DFS와 BFS
public class Step24 {

	// DFS와 BFS
	public static void p_1260() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		int[][] lines = new int[1001][1001];

		// 간선 정보 저장
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			lines[x][y] = lines[y][x] = 1;
		}

		sc.close();

		// dfs - 재귀 이용하기
		boolean[] visited = new boolean[n + 1];
		Arrays.fill(visited, false);

		// 시작점
		visited[v] = true;
		System.out.print(v + " ");

		dfs_1260(v, lines, visited);
		System.out.println();

		// bfs
		bfs_1260(n, v, lines);

		return;
	}

	public static void dfs_1260(int v, int[][] lines, boolean[] visited) {

		for (int i = 1; i <= 1000; i++) {
			// 연결되어있고 방문한적 없다면 방문처리, 다음 깊이로 진행
			if (lines[v][i] == 1 && !visited[i]) {
				System.out.print(i + " ");
				visited[i] = true;
				dfs_1260(i, lines, visited);
			}
		}

		return;
	}

	public static void bfs_1260(int n, int v, int[][] lines) {

		boolean[] visited = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder result = new StringBuilder();

		Arrays.fill(visited, false);

		// 시작점
		visited[v] = true;
		queue.offer(v);
		result.append(v + " ");

		while (!queue.isEmpty()) {
			int target = queue.poll();

			for (int i = 1; i <= n; i++) {
				// 연결되어있고 방문하지 않았다면 방문처리
				if (lines[target][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.offer(i);
					result.append(i + " ");
				}
			}
		}

		System.out.println(result.toString());

		return;
	}

	// 바이러스
	public static void p_2606() {
		Scanner sc = new Scanner(System.in);
		int computer = sc.nextInt();
		int count = sc.nextInt();
		int[][] lines = new int[computer + 1][computer + 1];

		for (int i = 0; i < count; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			lines[x][y] = lines[y][x] = 1;
		}

		sc.close();

		System.out.println(bfs_2606(computer, lines));

	}

	public static int bfs_2606(int n, int[][] lines) {

		int result = 0;

		boolean[] visited = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();

		// 초기화
		Arrays.fill(visited, false);
		queue.offer(1);
		visited[1] = true;

		// bfs 시작
		while (!queue.isEmpty()) {

			int target = queue.poll();

			for (int i = 1; i <= n; i++) {
				// 연결되어있고 방문하지 않았다면
				if (lines[target][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					result++;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// p_1260();
		p_2606();

		return;
	}

}
