package baekjoon_Study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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

		return;

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

	// 단지 번호 붙이기
	public static void p_2667() {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[][] houses = new int[n][n];

		for (int i = 0; i < n; i++) {
			char[] input = sc.nextLine().toCharArray();
			for (int j = 0; j < n; j++) {
				houses[i][j] = input[j] - '0';
			}
		}

		sc.close();

		bfs_2667(n, houses);

		return;
	}

	public static void bfs_2667(int n, int[][] houses) {
		int count = 0; // 단지 수
		List<Integer> list = new ArrayList<>();

		boolean[][] visited = new boolean[n][n];
		Queue<int[]> queue = new LinkedList<>();

		// 방문배열 초기화
		for (boolean[] arr : visited) {
			Arrays.fill(arr, false);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				// 집이 존재하고 방문한 적이 없다면 bfs 시작
				if (houses[i][j] == 1 && !visited[i][j]) {

					count++; // 단지수 증가
					int house = 1; // 단지 내 집의 수

					// 초기화
					queue.offer(new int[] { i, j });
					visited[i][j] = true;

					while (!queue.isEmpty()) {
						int[] target = queue.poll();

						// 상
						if (target[1] + 1 >= 0 && target[1] + 1 < n) { // 범위 확인
							if (houses[target[0]][target[1] + 1] == 1 && !visited[target[0]][target[1] + 1]) {
								visited[target[0]][target[1] + 1] = true;
								queue.offer(new int[] { target[0], target[1] + 1 });
								house++;
							}
						}

						// 하
						if (target[1] - 1 >= 0 && target[1] - 1 < n) { // 범위 확인
							if (houses[target[0]][target[1] - 1] == 1 && !visited[target[0]][target[1] - 1]) {
								visited[target[0]][target[1] - 1] = true;
								queue.offer(new int[] { target[0], target[1] - 1 });
								house++;
							}
						}

						// 좌
						if (target[0] - 1 >= 0 && target[0] - 1 < n) { // 범위 확인
							if (houses[target[0] - 1][target[1]] == 1 && !visited[target[0] - 1][target[1]]) {
								visited[target[0] - 1][target[1]] = true;
								queue.offer(new int[] { target[0] - 1, target[1] });
								house++;
							}
						}

						// 우
						if (target[0] + 1 >= 0 && target[0] + 1 < n) { // 범위 확인
							if (houses[target[0] + 1][target[1]] == 1 && !visited[target[0] + 1][target[1]]) {
								visited[target[0] + 1][target[1]] = true;
								queue.offer(new int[] { target[0] + 1, target[1] });
								house++;
							}
						}
					}

					list.add(house);

				}

			}
		}

		Collections.sort(list);

		StringBuilder result = new StringBuilder(count + "\n");

		for (int i : list) {
			result.append(i + "\n");
		}

		System.out.println(result.toString());

		return;

	}

	// 유기농 배추
	public static void p_1012() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < t; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[][] ground = new int[m][n];

			// 배추 위치
			int num = sc.nextInt();
			for (int j = 0; j < num; j++) {
				ground[sc.nextInt()][sc.nextInt()] = 1;
			}

			result.append(bfs_1012(m, n, ground) + "\n");

		}

		sc.close();

		System.out.println(result.toString());

		return;
	}

	public static int bfs_1012(int m, int n, int[][] ground) {
		int result = 0;

		// ground가 0과 1 뿐이므로 visited 대신 ground를 0으로 바꿔주기
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 1이라면 bfs시작
				if (ground[i][j] == 1) {

					ground[i][j] = 0;
					queue.offer(new int[] { i, j });
					result++;

					while (!queue.isEmpty()) {
						int[] target = queue.poll();

						// 상
						if (target[1] + 1 >= 0 && target[1] + 1 < n) {
							if (ground[target[0]][target[1] + 1] == 1) {
								queue.offer(new int[] { target[0], target[1] + 1 });
								ground[target[0]][target[1] + 1] = 0;
							}
						}

						// 하
						if (target[1] - 1 >= 0 && target[1] - 1 < n) {
							if (ground[target[0]][target[1] - 1] == 1) {
								queue.offer(new int[] { target[0], target[1] - 1 });
								ground[target[0]][target[1] - 1] = 0;
							}
						}

						// 좌
						if (target[0] - 1 >= 0 && target[0] - 1 < m) {
							if (ground[target[0] - 1][target[1]] == 1) {
								queue.offer(new int[] { target[0] - 1, target[1] });
								ground[target[0] - 1][target[1]] = 0;
							}
						}

						// 우
						if (target[0] + 1 >= 0 && target[0] + 1 < m) {
							if (ground[target[0] + 1][target[1]] == 1) {
								queue.offer(new int[] { target[0] + 1, target[1] });
								ground[target[0] + 1][target[1]] = 0;
							}
						}

					}

				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// p_1260();
		// p_2606();
		// p_2667();
		p_1012();

		return;
	}

}
